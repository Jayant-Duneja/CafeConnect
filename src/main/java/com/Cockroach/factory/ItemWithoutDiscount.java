package com.Cockroach.factory;

public class ItemWithoutDiscount implements DiscountFactory {
    @Override
    public Double applyDiscount(Double originalPrice) {
        return originalPrice;
    }
}
