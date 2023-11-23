package com.Cockroach.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    private Long reviewid;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "cafeid")
    private Cafe cafe;

    private Long rating;
    private String comments;

    private Date reviewdate;

    // Constructors, getters, and setters
    public Reviews() {
        // Default constructor
    }

    public Reviews(Long reviewid, Users user, Cafe cafe, Long rating, String comments, Date reviewdate) {
        this.reviewid = reviewid;
        this.user = user;
        this.cafe = cafe;
        this.rating = rating;
        this.comments = comments;
        this.reviewdate = reviewdate;
    }

    public Long getReviewid() {
        return reviewid;
    }

    public void setReviewid(Long reviewid) {
        this.reviewid = reviewid;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getReviewdate() {
        return reviewdate;
    }

    public void setReviewdate(Date reviewdate) {
        this.reviewdate = reviewdate;
    }
}

