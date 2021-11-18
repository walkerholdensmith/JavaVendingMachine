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
    Map<String , String []> vendingMachineItems = new HashMap<>();
    Scanner userInputScanner = new Scanner(System.in);

    public Map<String, String[]> getVendingMachineItems() {
        return vendingMachineItems;
    }

    public void populateMap() {
        Scanner fileScanner;

        {
            try {
                //Create scanner Object to read file contents
                fileScanner = new Scanner(machineItems);
                //Iterate file
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    //Split each line of file by "|"
                    String[] itemList = line.split("\\|");
                    //Populate Map
                    if (!vendingMachineItems.containsKey(itemList[0])){
                        vendingMachineItems.put(itemList[0],itemList);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayItems(){
        populateMap();
        for (String [] items : vendingMachineItems.values() ){
            String name = items[1];
            String price = items [2];
            String amount = items[4];
            String slot = items[0];
            System.out.println("Slot:" + slot + " Name:" + name + " Price:" + price + " Amount:" +amount);

        }
    }

    public String itemSelection() {
        System.out.println("Please select and item based on slot number");
        String slotNumber = userInputScanner.nextLine();
        return slotNumber;
    }

    public void updateItem() {

    }



}
