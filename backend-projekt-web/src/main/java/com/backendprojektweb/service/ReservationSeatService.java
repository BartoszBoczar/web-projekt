package com.backendprojektweb.service;

import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.repository.ReservationSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationSeatService {
    @Autowired
    ReservationSeatRepository repository;

    public List<ReservationSeat> getReservationSeats() {
        List<ReservationSeat> result = repository.findAll();
        if(result.size() <= 0) {
            result = new ArrayList<ReservationSeat>();
        }
        return result;
    }

    public ReservationSeat getReservationSeat(Integer id) {
        ReservationSeat result = null;
        Optional<ReservationSeat> foundReservationSeat = repository.findById(id);
        if(foundReservationSeat.isPresent()) {
            result = foundReservationSeat.get();
        }
        return result;
    }

    public ReservationSeat updateReservationSeat(ReservationSeat reservationSeat) {
        ReservationSeat result;
        Optional<ReservationSeat> foundReservationSeat = repository.findById(reservationSeat.getId());
        if(foundReservationSeat.isPresent()) {
            result = foundReservationSeat.get();
            result.setScreeningId(reservationSeat.getScreeningId());
            result.setSeatId(reservationSeat.getSeatId());
            result.setDiscount(reservationSeat.getDiscount());
        }
        result = repository.save(reservationSeat);
        return result;
    }
}
