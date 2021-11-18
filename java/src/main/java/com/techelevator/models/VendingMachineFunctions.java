package com.techelevator.models;

import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;

public abstract class VendingMachineFunctions {


    Scanner inputScanner = new Scanner(System.in);
    File machineItems = new File("vendingmachine.csv");
    BigDecimal balance = new BigDecimal("0.00");


}
