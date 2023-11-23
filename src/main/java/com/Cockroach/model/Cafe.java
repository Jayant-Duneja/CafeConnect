package com.Cockroach.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cafe")
public class Cafe {
    @Id
    private Long cafeid;

    private String name;
    private String cuisine;
    private String description;
    private String location;
    private String contact;

    // Constructors, getters, and setters

    public Cafe() {
        // Default constructor
    }

    public Cafe(Long cafeid, String name, String cuisine, String description, String location, String contact) {
        this.cafeid = cafeid;
        this.name = name;
        this.cuisine = cuisine;
        this.description = description;
        this.location = location;
        this.contact = contact;
    }

    public Long getCafeid() {
        return cafeid;
    }

    public void setCafeid(Long cafeid) {
        this.cafeid = cafeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
