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
    @JoinColumn(name = "reservation")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "seat")
    private Seat seat;

    @Column(name = "discount")
    @Enumerated(EnumType.STRING)
    private Discount discount;

    public ReservationSeat(Reservation reservation, Seat seat) {
        this.reservation = reservation;
        this.seat = seat;
    }
}
