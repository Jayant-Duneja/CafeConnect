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
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "cafe_id", referencedColumnName = "cafe_id")
    private Cafe cafe;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_date")
    private Date review_date;

    @Transient
    private long student_id;

    @Transient
    private long cafe_id;

    // Constructors, getters, and setters
    public Review() {
        // Default constructor
    }

    public Review(long student_id, long cafe_id, int rating, String comment, Date review_date) {
        this.student_id = student_id;
        this.cafe_id = cafe_id;
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

    public void setRating(int rating) {
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

    public long getStudent_id() {
        if (this.student != null) {
            return this.student.getStudent_id();
        } else {
            return this.student_id;
        }
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getCafe_id() {
        if (this.cafe != null) {
            return this.cafe.getCafe_id();
        } else {
            return this.cafe_id;
        }
    }

    public void setCafe_id(long cafe_id) {
        this.cafe_id = cafe_id;
    }
}

