package com.backendprojektweb.service;

import com.backendprojektweb.model.Seat;
import com.backendprojektweb.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private final SeatRepository repository;

    @Transactional
    public List<Seat> getSeats() { return repository.findAll(); }

    @Transactional
    public Seat getSeat(Long id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Seat saveSeat(Seat seat) {
        return repository.save(seat);
    }
}
