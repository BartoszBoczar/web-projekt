package com.backendprojektweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "reservations")
public class Reservation extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screeningId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "reservationId")
    private List<ReservationSeat> reservationSeatList;
}
