package com.techelevator.models;

import java.math.BigDecimal;

public class Chips implements Items{
    private String slot;
    private String name;
    private BigDecimal price;
    private int amount;

    public Chips(String slot, String name, BigDecimal price, int amount){
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
}
