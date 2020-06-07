package com.backendprojektweb.model.dto;

import com.backendprojektweb.model.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDTO {
    private Reservation reservation;
    private List<SeatDTO> seatDTOList;
    private Long screeningId;
}
