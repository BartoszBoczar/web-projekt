package com.backendprojektweb.model;

import javax.persistence.*;

@Entity
@Table(name = "reservations_seats")
public class ReservationSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screeningId;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seatId;

    @Column(name = "discount")
    private Discount discount;

    public ReservationSeat() {
    }

    public ReservationSeat(int id, Screening screeningId, Seat seatId, Discount discount) {
        this.id = id;
        this.screeningId = screeningId;
        this.seatId = seatId;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Screening getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Screening screeningId) {
        this.screeningId = screeningId;
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
