package com.Cockroach.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;
    private String student_name;
    private String cu_email;
    private byte[] profile_image;
    private Date reg_date;


    // Constructors, getters, and setters
    public Student() {
        // Default constructor
    }

    public Student(String userName, String cuEmail, byte[] profileImage, Date regDate) {
        this.student_name = userName;
        this.cu_email = cuEmail;
        this.profile_image = profileImage;
        this.reg_date = regDate;
    }


    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCu_email() {
        return cu_email;
    }

    public void setCu_email(String cu_email) {
        this.cu_email = cu_email;
    }

    public byte[] getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(byte[] profile_image) {
        this.profile_image = profile_image;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }
}

