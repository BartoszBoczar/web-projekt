package com.backendprojektweb.service;

import com.backendprojektweb.model.Reservation;
import com.backendprojektweb.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository repository;

    public List<Reservation> getReservations() {
        List<Reservation> result = repository.findAll();
        if(result.size() <= 0) {
            result = new ArrayList<Reservation>();
        }
        return result;
    }

    public Reservation getReservation(Integer id) {
        Reservation result = null;
        Optional<Reservation> foundReservation = repository.findById(id);
        if(foundReservation.isPresent()) {
            result = foundReservation.get();
        }
        return result;
    }

    public Reservation updateReservation(Reservation reservation) {
        Reservation result;
        Optional<Reservation> foundReservation = repository.findById(reservation.getId());
        if(foundReservation.isPresent()) {
            result = foundReservation.get();
            result.setScreeningId(reservation.getScreeningId());
            result.setEmail(reservation.getEmail());
            result.setName(reservation.getName());
            result.setSurname(reservation.getSurname());
        }
        result = repository.save(reservation);
        return result;
    }
}
