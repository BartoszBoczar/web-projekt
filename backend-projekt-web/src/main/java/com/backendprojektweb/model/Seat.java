package com.backendprojektweb.model;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "row")
    private int row;

    @Column(name = "column")
    private int column;

    public Seat() {
    }

    public Seat(int id, int row, int column) {
        this.id = id;
        this.row = row;
        this.column = column;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
