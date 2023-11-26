package com.Cockroach.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long item_id;

    @NotNull
    @Column(name = "cafe_id")
    private long cafe_id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;


    // Constructors, getters, and setters

    public Menu() {
        // Default constructor
    }

    public Menu(long item_id, long cafe_id, String name, String description, Double price) {
        this.item_id = item_id;
        this.cafe_id = cafe_id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public long getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(long cafe_id) {
        this.cafe_id = cafe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
