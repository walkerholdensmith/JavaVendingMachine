package com.techelevator.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BeverageTest {

    private Beverage beverage;

    @Before
    public void setup() {
        this.beverage = new Beverage("T1","Drink",new BigDecimal("2.50"),5);
    }


    @Test
    public void testGetSlot() {
        String expectedResult = "T1";
        String actualResult = beverage.getSlot();

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testGetName() {
        String expectedResult = "Drink";
        String actualResult = beverage.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetPrice() {
        BigDecimal expectedResult = new BigDecimal("2.50");
        BigDecimal actualResult = beverage.getPrice();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testGetAmount() {
        int expectedResult = 5;
        int actualResult = beverage.getAmount();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetSound() {
        String expectedResult = "Glug Glug, Yum!";
        String actualResult = beverage.getSound();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetSlot() {
        String expectedResult = "A1";
        beverage.setSlot(expectedResult);
        String actualResult = beverage.getSlot();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetName() {
        String expectedResult = "NotDrink";
        beverage.setName(expectedResult);
        String actualResult = beverage.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSetPrice() {
        BigDecimal expectedResult = new BigDecimal("4.20");
        beverage.setPrice(expectedResult);
        BigDecimal actualResult = beverage.getPrice();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetAmount() {
        int expectedResult = 3;
        beverage.setAmount(expectedResult);
        int actualResult = beverage.getAmount();

        assertEquals(expectedResult, actualResult);
    }


}