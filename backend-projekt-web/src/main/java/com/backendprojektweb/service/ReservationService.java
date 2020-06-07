package com.backendprojektweb.service;

import com.backendprojektweb.exceptions.ReferenceNotPresentException;
import com.backendprojektweb.model.*;
import com.backendprojektweb.model.dto.ReservationDTO;
import com.backendprojektweb.model.dto.SeatDTO;
import com.backendprojektweb.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    private final ReservationSeatRepository reservationSeatRepository;
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final ReservationSeatService reservationSeatService;

    @Transactional
    public List<Reservation> getReservations() { return repository.findAll(); }

    @Transactional
    public Reservation getReservation(Long id) { return repository.findById(id).orElse(null); }

    @Transactional(rollbackOn = ReferenceNotPresentException.class)
    public Reservation saveReservation(ReservationDTO reservationDTO) throws ReferenceNotPresentException {
        if(reservationDTO.getSeatDTOList().isEmpty()) {
            return null;
        }
        // Check which seats are not available
        List<Seat> unavailableSeats = reservationSeatRepository.unavailableSeatsDuringScreening(reservationDTO.getScreeningId());

        for(Seat unavailableSeat : unavailableSeats) {
            for(SeatDTO seatDTO : reservationDTO.getSeatDTOList()) {
                Seat seatToReserve = seatDTO.getSeat();
                // Throw exception if any of the seats meant to be reserved are already reserved
                if(unavailableSeat.getColumn() == seatToReserve.getColumn() && unavailableSeat.getRow() == seatToReserve.getRow()) {
                    throw new ReferenceNotPresentException();
                }
            }
        }
        // Check if screening is present
        Optional<Screening> screeningOptional = screeningRepository.findById(reservationDTO.getScreeningId());
        if(!screeningOptional.isPresent()) {
            throw new ReferenceNotPresentException();
        }
        reservationDTO.getReservation().setScreening(screeningOptional.get());
        // Check if reservation is present
        Optional<Reservation> foundReservation = repository.findById(reservationDTO.getReservation().getId());
        Reservation savedReservation;
        if(foundReservation.isPresent()) {
            savedReservation = foundReservation.get();
            savedReservation.setSurname(reservationDTO.getReservation().getSurname());
            savedReservation.setName(reservationDTO.getReservation().getName());
            savedReservation.setEmail(reservationDTO.getReservation().getEmail());
            savedReservation = repository.save(savedReservation);
        } else {
            savedReservation = repository.save(reservationDTO.getReservation());
        }
        // Find all seats to be reserved
        List<Seat> seatsInHall = seatRepository.seatsInHall(reservationDTO.getSeatDTOList().get(0).getHallId());
        List<ReservationSeat> reservationSeatsToSave = new ArrayList<>();
        for(Seat seatInHall: seatsInHall) {
            for(SeatDTO seatDTO : reservationDTO.getSeatDTOList()) {
                Seat seatToBeReserved = seatDTO.getSeat();
                if(seatToBeReserved.getColumn() == 0 && seatToBeReserved.getRow() == 4) {
                    int a = 0;
                }
                if(seatInHall.getRow() == seatToBeReserved.getRow() && seatInHall.getColumn() == seatToBeReserved.getColumn()) {
                    reservationSeatsToSave.add(new ReservationSeat(savedReservation, seatInHall));
                }
            }
        }
        // Save all reservation seats
        for(ReservationSeat reservationSeatToSave: reservationSeatsToSave) {
            reservationSeatRepository.save(reservationSeatToSave);
        }
        return savedReservation;
    }
}
