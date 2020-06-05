package com.backendprojektweb.service;

import com.backendprojektweb.model.Movie;
import com.backendprojektweb.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository repository;

    @Transactional
    public List<Movie> getMovies() { return repository.findAll(); }

    @Transactional
    public Movie getMovie(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }
}
