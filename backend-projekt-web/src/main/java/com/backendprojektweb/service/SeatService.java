package com.backendprojektweb.service;

import com.backendprojektweb.model.Seat;
import com.backendprojektweb.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class SeatService {
    private final SeatRepository repository;

    public List<Seat> getSeats() { return repository.findAll(); }

    public Seat getSeat(Long id) { return repository.findById(id).orElse(null); }

    public Seat saveSeat(Seat seat) {
        return repository.save(seat);
    }
}
