package com.Cockroach.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long review_id;

    @NotNull
    @Column(name = "cafe_id")
    private long cafe_id;

    @NotNull
    @Column(name = "student_id")
    private long student_id;

    @NotNull
    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @NotNull
    @Column(name = "review_date")
    private LocalDate review_date;

    public Review() {}

    public Review(long cafe_id, long student_id, Integer rating, String comment, LocalDate review_date) {
        this.cafe_id = cafe_id;
        this.student_id = student_id;
        this.rating = rating;
        this.comment = comment;
        this.review_date = review_date;
    }

    public long getReview_id() {
        return review_id;
    }

    public void setReview_id(long review_id) {
        this.review_id = review_id;
    }

    public long getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(long cafe_id) {
        this.cafe_id = cafe_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getReview_date() {
        return review_date;
    }

    public void setReview_date(LocalDate review_date) {
        this.review_date = review_date;
    }
}
