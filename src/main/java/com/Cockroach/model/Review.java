package com.Cockroach.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long review_id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    private Long rating;
    private String comment;

    private Date review_date;

    // Constructors, getters, and setters
    public Review() {
        // Default constructor
    }

    public Review(Student student, Cafe cafe, Long rating, String comments, Date reviewdate) {
        this.student = student;
        this.cafe = cafe;
        this.rating = rating;
        this.comment = comments;
        this.review_date = reviewdate;
    }

    public long getReview_id() {
        return review_id;
    }

    public void setReview_id(long review_id) {
        this.review_id = review_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comment;
    }

    public void setComments(String comments) {
        this.comment = comments;
    }

    public Date getReviewdate() {
        return review_date;
    }

    public void setReviewdate(Date reviewdate) {
        this.review_date = reviewdate;
    }
}

