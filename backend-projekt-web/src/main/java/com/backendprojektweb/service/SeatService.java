package com.backendprojektweb.service;

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

    @Transactional
    public Seat saveSeat(SeatDTO seatDTO) {
        Optional<Hall> foundHall = hallRepository.findById(seatDTO.getHallId());
        if(!foundHall.isPresent()) {
            return null;
        }
        seatDTO.getSeat().setHall(foundHall.get());
        return repository.save(seatDTO.getSeat());
    }
}
