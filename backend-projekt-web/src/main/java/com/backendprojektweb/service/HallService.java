package com.backendprojektweb.service;

import com.backendprojektweb.model.Hall;
import com.backendprojektweb.repository.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class HallService {
    private final HallRepository repository;

    @Transactional
    public List<Hall> getHalls() { return repository.findAll(); }

    @Transactional
    public Hall getHall(Long id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Hall saveHall(Hall hall) {
        return repository.save(hall);
    }
}
