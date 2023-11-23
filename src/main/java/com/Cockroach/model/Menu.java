package com.Cockroach.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Menu {

    @Id
    private int item_id;
    @ManyToOne
    @JoinColumn(name = "cafe_id", referencedColumnName = "cafe_id")
    private Cafe cafe_id;
    private String name;
    private String description;
    private String price;

    // Default constructor
    public Menu() {

    }

    // Parameterized constructor
    public Menu(int item_id, Cafe cafe_id, String name, String description, String price) {
        this.item_id = item_id;
        this.cafe_id = cafe_id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getter and Setter methods

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public Cafe getCafe_id() {
        return cafe_id;
    }

    public void setCafe_id(Cafe cafe_id) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
