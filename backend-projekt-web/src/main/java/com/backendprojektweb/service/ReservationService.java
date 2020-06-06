package com.backendprojektweb.service;

import com.backendprojektweb.exceptions.ReferenceNotPresentException;
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
    private final ReservationSeatService reservationSeatService;

    @Transactional
    public List<Reservation> getReservations() { return repository.findAll(); }

    @Transactional
    public Reservation getReservation(Long id) { return repository.findById(id).orElse(null); }

    @Transactional(rollbackOn = ReferenceNotPresentException.class)
    public Reservation saveReservation(ReservationDTO reservationDTO) throws ReferenceNotPresentException {
        // Check which seats are not available
        List<ReservationSeat> unavailableReservationSeats = reservationSeatRepository.unavailableSeatsDuringScreening(reservationDTO.getReservation().getScreening().getId());
        for(ReservationSeat unavailableReservationSeat : unavailableReservationSeats) {
            for(ReservationSeatDTO reservationSeatDTO : reservationDTO.getReservationSeatDTOList()) {
                ReservationSeat toBeReservedSeat = reservationSeatDTO.getReservationSeat();
                // Return if any of the seats meant to be reserved are already reserved
                if(toBeReservedSeat.getSeat().getId() == unavailableReservationSeat.getSeat().getId()) {
                    throw new ReferenceNotPresentException();
                }
            }
        }
        // Save the whole reservation
        Optional<Screening> screeningOptional = screeningRepository.findById(reservationDTO.getScreeningId());
        if(!screeningOptional.isPresent()) {
            throw new ReferenceNotPresentException();
        }
        reservationDTO.getReservation().setScreening(screeningOptional.get());
        Reservation savedReservation = repository.save(reservationDTO.getReservation());
        // Save all reservation seats
        for(ReservationSeatDTO reservationSeatDTO : reservationDTO.getReservationSeatDTOList()) {
            reservationSeatService.saveReservationSeat(reservationSeatDTO);
        }
        return savedReservation;
    }
}
