package com.backendprojektweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seat extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "hall")
    private Hall hall;

    @Column(name = "seat_row")
    private int row;

    @Column(name = "seat_column")
    private int column;
}
