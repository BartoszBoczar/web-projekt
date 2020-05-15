package com.backendprojektweb.service;

import com.backendprojektweb.model.Seat;
import com.backendprojektweb.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SeatService {
    @Autowired
    SeatRepository repository;

    public List<Seat> getSeats() {
        List<Seat> result = repository.findAll();
        if(result.size() <= 0) {
            result = new ArrayList<Seat>();
        }
        return result;
    }

    public Seat getSeat(Integer id) {
        Seat result = null;
        Optional<Seat> foundSeat = repository.findById(id);
        if(foundSeat.isPresent()) {
            result = foundSeat.get();
        }
        return result;
    }

    public Seat updateSeat(Seat seat) {
        Seat result;
        Optional<Seat> foundSeat = repository.findById(seat.getId());
        if(foundSeat.isPresent()) {
            result = foundSeat.get();
            result.setHallId(seat.getHallId());
            result.setColumn(seat.getColumn());
            result.setRow(seat.getRow());
        }
        result = repository.save(seat);
        return result;
    }
}
