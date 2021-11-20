package com.techelevator.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipsTest {

    private Chips chips;

    @Before
    public void setup() {
        this.chips = new Chips("T1","Chips",new BigDecimal("2.50"),5);
    }


    @Test
    public void testGetSlot() {
        String expectedResult = "T1";
        String actualResult = chips.getSlot();

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testGetName() {
        String expectedResult = "Chips";
        String actualResult = chips.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetPrice() {
        BigDecimal expectedResult = new BigDecimal("2.50");
        BigDecimal actualResult = chips.getPrice();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testGetAmount() {
        int expectedResult = 5;
        int actualResult = chips.getAmount();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetSound() {
        String expectedResult = "Crunch Crunch, Yum!";
        String actualResult = chips.getSound();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetSlot() {
        String expectedResult = "A1";
        chips.setSlot(expectedResult);
        String actualResult = chips.getSlot();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetName() {
        String expectedResult = "NotChips";
        chips.setName(expectedResult);
        String actualResult = chips.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSetPrice() {
        BigDecimal expectedResult = new BigDecimal("4.20");
        chips.setPrice(expectedResult);
        BigDecimal actualResult = chips.getPrice();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetAmount() {
        int expectedResult = 3;
        chips.setAmount(expectedResult);
        int actualResult = chips.getAmount();

        assertEquals(expectedResult, actualResult);
    }

}