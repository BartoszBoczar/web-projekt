package com.backendprojektweb.service;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.repository.ReservationSeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationSeatService {
    private final ReservationSeatRepository repository;

    @Transactional
    public List<ReservationSeat> getReservationSeats() { return repository.findAll(); }

    @Transactional
    public ReservationSeat getReservationSeat(Long id) { return repository.findById(id).orElse(null); }

    @Transactional
    public ReservationSeat saveReservationSeat(ReservationSeat reservationSeat) { return repository.save(reservationSeat); }
}
