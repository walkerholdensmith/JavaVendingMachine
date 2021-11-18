package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public  class VendingMachineFunctions {

    BigDecimal balance = new BigDecimal("0.00");
    File machineItems = new File("vendingmachine.csv");
    Map<String , List> vendingMachineItems = new HashMap<>();


    public String getTest() {
        Scanner fileScanner;

        {
            try {
                fileScanner = new Scanner(machineItems);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] itemList = line.split("\\|");


                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return "";
    }





}
