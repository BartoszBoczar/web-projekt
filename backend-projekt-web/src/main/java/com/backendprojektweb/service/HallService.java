package com.backendprojektweb.service;

import com.backendprojektweb.model.Hall;
import com.backendprojektweb.repository.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class HallService {
    private final HallRepository repository;

    public List<Hall> getHalls() { return repository.findAll(); }

    public Hall getHall(Long id) { return repository.findById(id).orElse(null); }

    public Hall saveHall(Hall hall) {
        return repository.save(hall);
    }
}
