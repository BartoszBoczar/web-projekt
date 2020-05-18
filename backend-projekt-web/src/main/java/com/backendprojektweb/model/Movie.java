package com.backendprojektweb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie extends AbstractEntity{
    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 2500)
    private String description;

    //Duration in minutes
    @Column(name = "duration")
    private long duration;

    @Column(name = "image_path")
    private String image;
}
