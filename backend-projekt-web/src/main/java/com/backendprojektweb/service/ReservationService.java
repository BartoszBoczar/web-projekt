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
        List<ReservationSeat> unavailableReservationSeats = reservationSeatRepository.unavailableSeatsDuringScreening(reservationDTO.getScreeningId());
        for(ReservationSeat unavailableReservationSeat : unavailableReservationSeats) {
            for(ReservationSeatDTO reservationSeatDTO : reservationDTO.getReservationSeatDTOList()) {
                Long seatId = reservationSeatDTO.getSeatId();
                // Return if any of the seats meant to be reserved are already reserved
                if(seatId == unavailableReservationSeat.getSeat().getId()) {
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
        // Save all reservation seats
        for(ReservationSeatDTO reservationSeatDTO : reservationDTO.getReservationSeatDTOList()) {
            reservationSeatDTO.setReservationId(savedReservation.getId());
            reservationSeatService.saveReservationSeat(reservationSeatDTO);
        }
        return savedReservation;
    }
}
