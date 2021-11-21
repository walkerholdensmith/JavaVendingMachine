package com.techelevator.models;

import java.math.BigDecimal;

public class Beverage implements Items {
    private String slot;
    private String name;
    private BigDecimal price;
    private int amount;
    public Beverage(String slot, String name, BigDecimal price, int amount){
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSound() {
        return "Glug Glug, Yum!";
    }
}


