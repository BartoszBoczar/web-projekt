package com.backendprojektweb.service;

import com.backendprojektweb.model.*;
import com.backendprojektweb.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    private final ReservationSeatRepository reservationSeatRepository;

    @Transactional
    public List<Reservation> getReservations() { return repository.findAll(); }

    @Transactional
    public Reservation getReservation(Long id) { return repository.findById(id).orElse(null); }

    @Transactional
    public Reservation saveReservation(ReservationWithReservationSeatList reservationWithReservationSeatList) {
        // Check which seats are not available
        List<ReservationSeat> unavailableReservationSeats = reservationSeatRepository.unavailableSeatsDuringScreening(reservationWithReservationSeatList.getReservation().getScreeningId().getId());
        for(ReservationSeat unavailableReservationSeat : unavailableReservationSeats) {
            for(ReservationSeat toBeReservedReservationSeat : reservationWithReservationSeatList.getReservationSeatList()) {
                // Return if any of the seats meant to be reserved are already reserved
                if(toBeReservedReservationSeat.getSeatId() == unavailableReservationSeat.getSeatId()) {
                    return null;
                }
            }
        }
        // Save the whole reservation
        Reservation savedReservation = repository.save(reservationWithReservationSeatList.getReservation());
        for(ReservationSeat reservationSeat : reservationWithReservationSeatList.getReservationSeatList()) {
            reservationSeatRepository.save(reservationSeat);
        }
        return savedReservation;
    }
}
