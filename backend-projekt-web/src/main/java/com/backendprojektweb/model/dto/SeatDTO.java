package com.backendprojektweb.model.dto;

import com.backendprojektweb.model.Hall;
import com.backendprojektweb.model.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatDTO {
    private Seat seat;
    private Long hallId;
}
