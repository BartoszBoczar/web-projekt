package com.backendprojektweb.model.dto;

import com.backendprojektweb.model.ReservationSeat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationSeatDTO {
    private ReservationSeat reservationSeat;
    private Long reservationId;
    private Long seatId;
}
