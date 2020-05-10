package com.web.backendprojektweb.model;

import javax.persistence.*;

@Entity
@Table(name = "reservations_seats")
public class ReservationSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screeningId;

    @Id
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seatId;

    @Column(name = "discount")
    private Discount discount;
}
