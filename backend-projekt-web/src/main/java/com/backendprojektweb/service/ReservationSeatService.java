package com.backendprojektweb.service;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.repository.ReservationSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationSeatService {
    private final ReservationSeatRepository repository;

    public List<ReservationSeat> getReservationSeats() { return repository.findAll(); }

    public ReservationSeat getReservationSeat(Long id) { return repository.findById(id).orElse(null); }

    public ReservationSeat saveReservationSeat(ReservationSeat reservationSeat) { return repository.save(reservationSeat); }
}
