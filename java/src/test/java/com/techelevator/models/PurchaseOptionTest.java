package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

public class PurchaseOptionTest {

    private PurchaseOption purchaseOption;
    VendingMachineItems vendingItems = new VendingMachineItems();
    VendingMachineFileManager outFile = new VendingMachineFileManager();
    @Before
    public void setup(){this.purchaseOption = new PurchaseOption(vendingItems, outFile);}


    @Test
    public void testIsValidDollar() {
        boolean expectedIsTrue1 = true;
        String amount1 = "5";
        boolean actualResult1 = purchaseOption.isValidDollar(amount1);

        assertEquals(expectedIsTrue1,actualResult1);

        boolean expectedIsTrue2 = true;
        String amount2 = "1";
        boolean actualResult2 = purchaseOption.isValidDollar(amount2);

        assertEquals(expectedIsTrue2,actualResult2);

        boolean expectedIsTrue3 = true;
        String amount3 = "2";
        boolean actualResult3 = purchaseOption.isValidDollar(amount3);

        assertEquals(expectedIsTrue3,actualResult3);

        boolean expectedIsTrue4 = true;
        String amount4 = "10";
        boolean actualResult4 = purchaseOption.isValidDollar(amount4);

        assertEquals(expectedIsTrue4,actualResult4);

        boolean expectedIsTrue5 = false;
        String amount5 = "89";
        boolean actualResult5 = purchaseOption.isValidDollar(amount5);

        assertEquals(expectedIsTrue5,actualResult5);
    }

    @Test
    public void testGetQuarters() {
        BigDecimal test1 = new BigDecimal("63.25");
        BigDecimal expectedResult1 = new BigDecimal("253");
        BigDecimal actualResult1 = purchaseOption.getQuarters(test1);

        assertEquals(expectedResult1, actualResult1);

        BigDecimal test2 = new BigDecimal("15.55");
        BigDecimal expectedResult2 = new BigDecimal("62");
        BigDecimal actualResult2 = purchaseOption.getQuarters(test2);

        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    public void testGetDimes() {
        BigDecimal test1 = new BigDecimal("63.25");
        BigDecimal expectedResult1 = new BigDecimal("632");
        BigDecimal actualResult1 = purchaseOption.getDimes(test1);

        assertEquals(expectedResult1, actualResult1);

        BigDecimal test2 = new BigDecimal("15.55");
        BigDecimal expectedResult2 = new BigDecimal("155");
        BigDecimal actualResult2 = purchaseOption.getDimes(test2);

        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    public void testGetNickles() {
        BigDecimal test1 = new BigDecimal("63.25");
        BigDecimal expectedResult1 = new BigDecimal("1265");
        BigDecimal actualResult1 = purchaseOption.getNickles(test1);

        assertEquals(expectedResult1, actualResult1);

        BigDecimal test2 = new BigDecimal("15.55");
        BigDecimal expectedResult2 = new BigDecimal("311");
        BigDecimal actualResult2 = purchaseOption.getNickles(test2);

        assertEquals(expectedResult2, actualResult2);
    }

    @Test
    public void testCreateChange() {
        BigDecimal testPrice = new BigDecimal("2.05");
        BigDecimal testAmount = new BigDecimal("20.00");
        String expectedResult = "Quarters: 71 Dimes: 2 Nickles: 0";
        purchaseOption.setBalance(new BigDecimal("17.95"));
        String actualResult = purchaseOption.createChange(testPrice,testAmount);

        boolean areStringsTheSame = expectedResult.equals(actualResult);
        assertTrue(areStringsTheSame);
    }

    @Test
    public void testIsANum() {
        String test1 = "8";
        String test2 = "C";
        boolean test1Result = true;
        boolean test2Result = false;

        boolean actualTest1 = purchaseOption.isANum(test1);
        boolean actualTest2 = purchaseOption.isANum(test2);

        assertEquals(test1Result,actualTest1);
        assertEquals(test2Result,actualTest2);

    }



}