package com.backendprojektweb.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movieId;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hallId;

    @Column(name = "begin_time")
    private LocalDateTime time;

    @Column(name = "price")
    private float price;

    public Screening() {
    }

    public Screening(int id, Movie movieId, Hall hallId, LocalDateTime time, float price) {
        this.id = id;
        this.movieId = movieId;
        this.hallId = hallId;
        this.time = time;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovieId() {
        return movieId;
    }

    public void setMovieId(Movie movieId) {
        this.movieId = movieId;
    }

    public Hall getHallId() {
        return hallId;
    }

    public void setHallId(Hall hallId) {
        this.hallId = hallId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
