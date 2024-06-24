package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String poster;
    private int releaseYear;
    private float lengthInMin;
    private float imdbRating;
    private String genres;

    // Getters and setters
}
