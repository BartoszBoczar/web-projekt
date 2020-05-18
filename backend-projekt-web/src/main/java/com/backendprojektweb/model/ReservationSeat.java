package com.backendprojektweb.model;

import com.backendprojektweb.model.enumerations.Discount;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "reservations_seats")
public class ReservationSeat extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservationId;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seatId;

    @Column(name = "discount")
    @Enumerated(EnumType.STRING)
    private Discount discount;
}
