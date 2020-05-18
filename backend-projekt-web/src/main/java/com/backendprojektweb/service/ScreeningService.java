package com.backendprojektweb.service;

import com.backendprojektweb.model.Screening;
import com.backendprojektweb.repository.ScreeningRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreeningService {
    private final ScreeningRepository repository;

    public List<Screening> getScreenings() { return repository.findAll(); }

    public Screening getScreening(Long id) { return repository.findById(id).orElse(null); }

    public Screening saveScreening(Screening screening) {
        return repository.save(screening);
    }
}
