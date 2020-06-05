package com.backendprojektweb.service;

import com.backendprojektweb.model.Screening;
import com.backendprojektweb.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreeningService {
    private final ScreeningRepository repository;

    @Transactional
    public List<Screening> getScreenings() { return repository.findAll(); }

    @Transactional
    public List<Screening> getScreeningsOfMovie(Long id) {
        List<Screening> a = repository.allScreeningsOfMovie(id);
        return a;
    }

    @Transactional
    public Screening getScreening(Long id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Screening saveScreening(Screening screening) {
        return repository.save(screening);
    }
}
