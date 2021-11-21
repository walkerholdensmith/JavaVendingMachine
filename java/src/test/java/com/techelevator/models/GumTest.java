package com.techelevator.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    private Gum gum;

    @Before
    public void setup() {
        this.gum = new Gum("T1","Gum",new BigDecimal("2.50"),5);
    }


    @Test
    public void testGetSlot() {
        String expectedResult = "T1";
        String actualResult = gum.getSlot();

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testGetName() {
        String expectedResult = "Gum";
        String actualResult = gum.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetPrice() {
        BigDecimal expectedResult = new BigDecimal("2.50");
        BigDecimal actualResult = gum.getPrice();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testGetAmount() {
        int expectedResult = 5;
        int actualResult = gum.getAmount();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testGetSound() {
        String expectedResult = "Chew Chew, Yum!";
        String actualResult = gum.getSound();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetSlot() {
        String expectedResult = "A1";
        gum.setSlot(expectedResult);
        String actualResult = gum.getSlot();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetName() {
        String expectedResult = "NotGum";
        gum.setName(expectedResult);
        String actualResult = gum.getName();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSetPrice() {
        BigDecimal expectedResult = new BigDecimal("4.20");
        gum.setPrice(expectedResult);
        BigDecimal actualResult = gum.getPrice();

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testSetAmount() {
        int expectedResult = 3;
        gum.setAmount(expectedResult);
        int actualResult = gum.getAmount();

        assertEquals(expectedResult, actualResult);
    }

}