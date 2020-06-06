package com.backendprojektweb.service;

import com.backendprojektweb.exceptions.ReferenceNotPresentException;
import com.backendprojektweb.model.Hall;
import com.backendprojektweb.model.Movie;
import com.backendprojektweb.model.Screening;
import com.backendprojektweb.model.dto.ScreeningDTO;
import com.backendprojektweb.repository.HallRepository;
import com.backendprojektweb.repository.MovieRepository;
import com.backendprojektweb.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScreeningService {
    private final ScreeningRepository repository;
    private final HallRepository hallRepository;
    private final MovieRepository movieRepository;

    @Transactional
    public List<Screening> getScreenings() { return repository.findAll(); }

    @Transactional
    public List<Screening> getScreeningsOfMovie(Long id) {
        return repository.allScreeningsOfMovie(id);
    }

    @Transactional
    public List<Screening> getScreeningsOfMovieFromNow(Long id) {
        return repository.allScreeningsOfMovieFromDate(id, LocalDateTime.now());
    }

    @Transactional
    public Screening getScreening(Long id) { return repository.findById(id).orElse(null); }

    @Transactional(rollbackOn = ReferenceNotPresentException.class)
    public Screening saveScreening(ScreeningDTO screeningDTO) throws ReferenceNotPresentException {
        Optional<Hall> foundHall = hallRepository.findById(screeningDTO.getHallId());
        if(!foundHall.isPresent()) {
            throw new ReferenceNotPresentException();
        }
        Optional<Movie> foundMovie = movieRepository.findById(screeningDTO.getMovieId());
        if(!foundMovie.isPresent()) {
            throw new ReferenceNotPresentException();
        }
        // Check if seat is present
        Screening screening;
        Optional<Screening> foundScreening = repository.findById(screeningDTO.getScreening().getId());
        if(foundScreening.isPresent()) {
            screening = foundScreening.get();
            screening.setTime(screeningDTO.getScreening().getTime());
            screening.setPrice(screeningDTO.getScreening().getPrice());
        } else {
            screening = screeningDTO.getScreening();
        }
        screening.setHall(foundHall.get());
        screening.setMovie(foundMovie.get());
        return repository.save(screening);
    }
}
