package com.Cockroach.model;

import com.Cockroach.factory.DiscountFactory;
import com.Cockroach.factory.ItemWithDiscount;
import com.Cockroach.factory.ItemWithoutDiscount;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column(name = "special_discount")
    private Double specialDiscount;

    @Transient
    private DiscountFactory discountFactory;

    @Transient
    private Double newPrice;

    public Menu() {
        updateDiscountFactory();
        updateNewPrice();
    }

    public Menu(long item_id, long cafe_id, String name, String description, Double price, Double specialDiscount) {
        this.item_id = item_id;
        this.cafe_id = cafe_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.specialDiscount = specialDiscount;
        updateDiscountFactory();
        updateNewPrice();
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

    public Double getSpecialDiscount() {
        return specialDiscount;
    }

    public void setSpecialDiscount(Double specialDiscount) {
        this.specialDiscount = specialDiscount;
        updateDiscountFactory();
        updateNewPrice();
    }

    public Double getNewPrice() {
        return newPrice;
    }

    private void updateDiscountFactory() {
        this.discountFactory = (specialDiscount != null) ? new ItemWithDiscount(specialDiscount) : new ItemWithoutDiscount();
    }

    private void updateNewPrice() {
        if (this.price != null && discountFactory != null) {
            this.newPrice = this.price - discountFactory.applyDiscount(this.price);
        } else {
            this.newPrice = this.price;
        }
    }

}
