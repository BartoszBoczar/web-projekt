package com.backendprojektweb.service;

import com.backendprojektweb.exceptions.ReferenceNotPresentException;
import com.backendprojektweb.model.Hall;
import com.backendprojektweb.model.Seat;
import com.backendprojektweb.model.dto.SeatDTO;
import com.backendprojektweb.repository.HallRepository;
import com.backendprojektweb.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatService {
    private final SeatRepository repository;
    private final HallRepository hallRepository;

    @Transactional
    public List<Seat> getSeats() { return repository.findAll(); }

    @Transactional
    public Seat getSeat(Long id) { return repository.findById(id).orElse(null); }

    @Transactional(rollbackOn = ReferenceNotPresentException.class)
    public Seat saveSeat(SeatDTO seatDTO) throws ReferenceNotPresentException {
        Optional<Hall> foundHall = hallRepository.findById(seatDTO.getHallId());
        if(!foundHall.isPresent()) {
            throw new ReferenceNotPresentException();
        }
        // Check if seat is present
        Seat seat;
        Optional<Seat> foundSeat = repository.findById(seatDTO.getSeat().getId());
        if(foundSeat.isPresent()) {
            seat = foundSeat.get();
            seat.setRow(seatDTO.getSeat().getRow());
            seat.setColumn(seatDTO.getSeat().getColumn());
        } else {
            seat = seatDTO.getSeat();
        }
        seat.setHall(foundHall.get());
        return repository.save(seat);
    }
}
