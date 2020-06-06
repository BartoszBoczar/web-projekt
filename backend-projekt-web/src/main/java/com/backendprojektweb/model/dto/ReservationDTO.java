package com.backendprojektweb.model.dto;

import com.backendprojektweb.model.Reservation;
import com.backendprojektweb.model.ReservationSeat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDTO {
    private Reservation reservation;
    private List<ReservationSeatDTO> reservationSeatDTOList;
    private Long screeningId;
}
