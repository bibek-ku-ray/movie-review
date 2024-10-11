package com.bibek.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reviewRates")
public class ReviewRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float rate;
    private String review;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ReviewRate(float rate, String review, int movie_id) {
        this.rate = rate;
        this.review = review;
    }

    public ReviewRate() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
