package com.backendprojektweb.service;

import com.backendprojektweb.exceptions.ReferenceNotPresentException;
import com.backendprojektweb.model.Reservation;
import com.backendprojektweb.model.ReservationSeat;
import com.backendprojektweb.model.Seat;
import com.backendprojektweb.model.dto.ReservationSeatDTO;
import com.backendprojektweb.repository.ReservationRepository;
import com.backendprojektweb.repository.ReservationSeatRepository;
import com.backendprojektweb.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationSeatService {
    private final ReservationSeatRepository repository;
    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;

    @Transactional
    public List<ReservationSeat> getReservationSeats() { return repository.findAll(); }

    @Transactional
    public ReservationSeat getReservationSeat(Long id) { return repository.findById(id).orElse(null); }

    @Transactional
    public List<ReservationSeat> getUnavailableReservationSeats(Long screeningId) { return repository.unavailableSeatsDuringScreening(screeningId); }

    @Transactional(rollbackOn = ReferenceNotPresentException.class)
    public ReservationSeat saveReservationSeat(ReservationSeatDTO reservationSeatDTO) throws ReferenceNotPresentException{
        Optional<Seat> seatOptional = seatRepository.findById(reservationSeatDTO.getSeatId());
        Optional<Reservation> reservationOptional = reservationRepository.findById(reservationSeatDTO.getReservationId());
        if(!reservationOptional.isPresent() || !seatOptional.isPresent()) {
            throw new ReferenceNotPresentException();
        }
        // Check if reservationSeat is present
        ReservationSeat reservationSeat;
        Optional<ReservationSeat> foundReservationSeat = repository.findById(reservationSeatDTO.getReservationSeat().getId());
        if(foundReservationSeat.isPresent()) {
            reservationSeat = foundReservationSeat.get();
            reservationSeat.setDiscount(reservationSeatDTO.getReservationSeat().getDiscount());
        } else {
            reservationSeat = reservationSeatDTO.getReservationSeat();
        }
        reservationSeat.setSeat(seatOptional.get());
        reservationSeat.setReservation(reservationOptional.get());
        return repository.save(reservationSeat);
    }
}
