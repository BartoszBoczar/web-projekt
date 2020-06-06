package com.backendprojektweb.service;

import com.backendprojektweb.model.*;
import com.backendprojektweb.model.dto.ReservationDTO;
import com.backendprojektweb.model.dto.ReservationSeatDTO;
import com.backendprojektweb.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    private final ReservationSeatRepository reservationSeatRepository;
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;

    @Transactional
    public List<Reservation> getReservations() { return repository.findAll(); }

    @Transactional
    public Reservation getReservation(Long id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Reservation saveReservation(ReservationDTO reservationDTO) {
        // Check which seats are not available
        List<ReservationSeat> unavailableReservationSeats = reservationSeatRepository.unavailableSeatsDuringScreening(reservationDTO.getReservation().getScreening().getId());
        for(ReservationSeat unavailableReservationSeat : unavailableReservationSeats) {
            for(ReservationSeatDTO reservationSeatDTO : reservationDTO.getReservationSeatDTOList()) {
                ReservationSeat toBeReservedSeat = reservationSeatDTO.getReservationSeat();
                // Return if any of the seats meant to be reserved are already reserved
                if(toBeReservedSeat.getSeat().getId() == unavailableReservationSeat.getSeat().getId()) {
                    return null;
                }
            }
        }
        // Save the whole reservation
        Optional<Screening> screeningOptional = screeningRepository.findById(reservationDTO.getScreeningId());
        if(!screeningOptional.isPresent()) {
            return null;
        }
        reservationDTO.getReservation().setScreening(screeningOptional.get());
        Reservation savedReservation = repository.save(reservationDTO.getReservation());
        for(ReservationSeatDTO reservationSeatDTO : reservationDTO.getReservationSeatDTOList()) {
            ReservationSeat reservationSeat = reservationSeatDTO.getReservationSeat();
            Optional<Seat> seatOptional = seatRepository.findById(reservationSeatDTO.getSeatId());
            if(!seatOptional.isPresent()) {
                return null;
            }
            reservationSeat.setSeat(seatOptional.get());
            reservationSeat.setReservation(savedReservation);
            reservationSeatRepository.save(reservationSeat);
        }
        return savedReservation;
    }
}
