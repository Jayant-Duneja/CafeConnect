package com.Cockroach.model;

import javax.persistence.*;


@Entity
@Table(name = "cafe")
public class Cafe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cafe_id;
    private String name;
    private String cuisine;
    private String description;
    private String location;
    private String contact;

    public Cafe() {}

    public Cafe(String name, String cuisine, String description, String location, String contact, String observers_id_list) {
        this.name = name;
        this.cuisine = cuisine;
        this.description = description;
        this.location = location;
        this.contact = contact;
    }

    public String getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(String cafe_id) {
        this.cafe_id = cafe_id;
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
