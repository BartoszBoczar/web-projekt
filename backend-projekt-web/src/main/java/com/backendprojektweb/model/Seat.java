package com.backendprojektweb.model;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hallId;

    @Column(name = "seat_row")
    private int row;

    @Column(name = "seat_column")
    private int column;

    public Seat() {
    }

    public Seat(int id, Hall hallId, int row, int column) {
        this.id = id;
        this.hallId = hallId;
        this.row = row;
        this.column = column;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hall getHallId() { return hallId; }

    public void setHallId(Hall hallId) { this.hallId = hallId; }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
