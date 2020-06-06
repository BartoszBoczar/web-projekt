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
    @JoinColumn(name = "movie")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "hall")
    private Hall hall;

    @Column(name = "begin_time")
    private LocalDateTime time;

    @Column(name = "price")
    private float price;
}
