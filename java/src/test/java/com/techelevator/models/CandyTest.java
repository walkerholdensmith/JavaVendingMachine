package com.techelevator.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    private Candy candy;

    @Before
    public void setup() {
        this.candy = new Candy("T1","Candy",new BigDecimal("2.50"),5);
    }


    @Test
    public void testGetSlot() {
        String expectedResult = "T1";
        String actualResult = candy.getSlot();

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testGetName() {
        String expectedResult = "Candy";
        String actualResult = candy.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetPrice() {
        BigDecimal expectedResult = new BigDecimal("2.50");
        BigDecimal actualResult = candy.getPrice();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testGetAmount() {
        int expectedResult = 5;
        int actualResult = candy.getAmount();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetSound() {
        String expectedResult = "Munch Munch, Yum!";
        String actualResult = candy.getSound();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetSlot() {
        String expectedResult = "A1";
        candy.setSlot(expectedResult);
        String actualResult = candy.getSlot();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetName() {
        String expectedResult = "NotCandy";
        candy.setName(expectedResult);
        String actualResult = candy.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSetPrice() {
        BigDecimal expectedResult = new BigDecimal("4.20");
        candy.setPrice(expectedResult);
        BigDecimal actualResult = candy.getPrice();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetAmount() {
        int expectedResult = 3;
        candy.setAmount(expectedResult);
        int actualResult = candy.getAmount();

        assertEquals(expectedResult, actualResult);
    }

}