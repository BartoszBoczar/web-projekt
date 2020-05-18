package com.backendprojektweb.service;

import com.backendprojektweb.model.Reservation;
import com.backendprojektweb.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;

    public List<Reservation> getReservations() { return repository.findAll(); }

    public Reservation getReservation(Long id) { return repository.findById(id).orElse(null); }

    public Reservation saveReservation(Reservation reservation) {
        return repository.save(reservation);
    }
}
