package com.backendprojektweb.model;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screeningId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    public Reservation() {
    }

    public Reservation(int id, Screening screeningId, String name, String surname, String email) {
        this.id = id;
        this.screeningId = screeningId;
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
