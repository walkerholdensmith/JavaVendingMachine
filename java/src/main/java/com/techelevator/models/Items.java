package com.techelevator.models;

import java.math.BigDecimal;

public interface Items{
    String getSlot();
    String getName();
    BigDecimal getPrice();
    int getAmount();
    String getSound();


    public void setAmount(int amount);


}
