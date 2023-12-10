package com.Cockroach.strategy;

public class ItemWithDiscount implements DiscountStrategy {
    private final Double specialDiscount;

    public ItemWithDiscount(Double specialDiscount) {
        this.specialDiscount = specialDiscount;
    }

    @Override
    public Double applyDiscount(Double originalPrice) {
        double discountAmount = originalPrice * (specialDiscount / 100.0);
        return originalPrice - discountAmount;
    }

}