package com.backendprojektweb.model;


import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 2500)
    private String description;

    //Duration in minutes
    @Column(name = "duration")
    private long duration;

    @Column(name = "image_path", nullable = true)
    private String image;

    public Movie() {
    }

    public Movie(int id, String title, String description, long duration, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
