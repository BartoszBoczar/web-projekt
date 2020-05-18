package com.backendprojektweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "screenings")
public class Screening extends AbstractEntity {
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
}
