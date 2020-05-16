package com.backendprojektweb.model;

import com.backendprojektweb.model.enumerations.Discount;

import javax.persistence.*;

@Entity
@Table(name = "reservations_seats")
public class ReservationSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservationId;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seatId;

    @Column(name = "discount")
    @Enumerated(EnumType.STRING)
    private Discount discount;

    public ReservationSeat() {
    }

    public ReservationSeat(int id, Reservation reservationId, Seat seatId, Discount discount) {
        this.id = id;
        this.reservationId = reservationId;
        this.seatId = seatId;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reservation getReservationId() {
        return reservationId;
    }

    public void setReservationId(Reservation reservationId) {
        this.reservationId = reservationId;
    }

    public Seat getSeatId() {
        return seatId;
    }

    public void setSeatId(Seat seatId) {
        this.seatId = seatId;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
