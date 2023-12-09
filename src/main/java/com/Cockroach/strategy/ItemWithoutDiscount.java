package com.Cockroach.strategy;

public class ItemWithoutDiscount implements DiscountStrategy {
    @Override
    public Double applyDiscount(Double originalPrice) {
        return originalPrice;
    }
}
