package com.techelevator.models;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class VendingMachineItemsTest {

    VendingMachineItems vendingMachineItems;

    @Before
    public void setup() {
        this.vendingMachineItems = new VendingMachineItems();

    }



    @Test
   public void testGetAmount() {
        int expectedResult = 5;
        int actualResult = vendingMachineItems.getAmount("A2");

        assertEquals(expectedResult,actualResult);
   }

    @Test
    public void testGetItemPrice() {
        String testSlot = "B3";
        BigDecimal expectedResult = new BigDecimal("1.50");
        BigDecimal actualResult = vendingMachineItems.getItemPrice(testSlot);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void testGetName() {
        String testSlot = "C2";
        String expectedResult = "Dr. Salt";
        String actualResult = vendingMachineItems.getName(testSlot);

        assertEquals(expectedResult,actualResult);
    }

}