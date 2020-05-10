package com.backendprojektweb.model;

import javax.persistence.*;

@Entity
@Table(name = "halls_seats")
public class HallSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hallId;

    @Id
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seatId;

    public HallSeat() {
    }

    public HallSeat(int id, Hall hallId, Seat seatId) {
        this.id = id;
        this.hallId = hallId;
        this.seatId = seatId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hall getHallId() {
        return hallId;
    }

    public void setHallId(Hall hallId) {
        this.hallId = hallId;
    }

    public Seat getSeatId() {
        return seatId;
    }

    public void setSeatId(Seat seatId) {
        this.seatId = seatId;
    }
}
