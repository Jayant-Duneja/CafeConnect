package com.Cockroach.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "users")

public class Users {
    @Id
    private int userid;

    private String username;
    private String cuemail;
    private byte[] profileimage;
    private Date regdate;


    // Constructors, getters, and setters
    public Users() {
        // Default constructor
    }

    public Users(String userName, String cuEmail, byte[] profileImage, Date regDate) {
        this.username = userName;
        this.cuemail = cuEmail;
        this.profileimage = profileImage;
        this.regdate = regDate;
    }


    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getCuEmail() {
        return cuemail;
    }

    public void setCuEmail(String cuEmail) {
        this.cuemail = cuEmail;
    }

    public byte[] getProfileImage() {
        return profileimage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileimage = profileImage;
    }

    public Date getRegDate() {
        return regdate;
    }

    public void setRegDate(Date regDate) {
        this.regdate = regDate;
    }
}
