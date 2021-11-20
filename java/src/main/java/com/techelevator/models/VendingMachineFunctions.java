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
    Map<String , Items > vendingMachineItems = new HashMap<>();
    Scanner userInputScanner = new Scanner(System.in);

    public Map<String, Items> getVendingMachineItems() {
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
                    String slot = itemList[0];
                    String name = itemList[1];
                    BigDecimal price = new BigDecimal(itemList[2]);
                    String type = itemList[3];
                    int amount = Integer.parseInt(itemList[4]);

                    if (type.equals("Chip")){
                        Chips newItem = new Chips(slot,name,price,amount);
                        vendingMachineItems.put(slot,newItem);

                    } else if (type.equals("Candy")){
                        Candy newItem = new Candy(slot,name,price,amount);
                        vendingMachineItems.put(slot,newItem);
                    } else if (type.equals("Gum")){
                        Gum newItem = new Gum(slot,name,price,amount);
                        vendingMachineItems.put(slot,newItem);
                    } else {
                        Beverage newItem = new Beverage(slot,name,price,amount);
                        vendingMachineItems.put(slot,newItem);
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    public void displayItems(){

        for (Items item : vendingMachineItems.values()){

            System.out.println("Slot:" + item.getSlot() + " Name:" + item.getName() + " Price:" + item.getPrice() + " Amount:" + item.getAmount());

        }

    }

    public boolean isInMachine(String itemSlot){
        Items value = vendingMachineItems.get(itemSlot);
        if (value != null) {
            return true;
        } else {
            return false;
        }
    }


    public int getAmount(String itemSlot){

        return vendingMachineItems.get(itemSlot).getAmount();
    }

    public String itemSelection() {
        System.out.println("Please select and item based on slot number");

        String slotNumber = userInputScanner.nextLine();
        return slotNumber;
    }

    public void updateItem(String itemSlot, BigDecimal value) {
        int decrease = vendingMachineItems.get(itemSlot).getAmount()-1;
        //System.out.println(increase);
        vendingMachineItems.get(itemSlot).setAmount(decrease);
        BigDecimal price = vendingMachineItems.get(itemSlot).getPrice();
        increaseBalance(price);

    }

    public String createChange(BigDecimal price, BigDecimal amount){
        String coinChange = "Quarter: ";
        BigDecimal change = amount.subtract(price);

        System.out.println(change);
        BigDecimal quarters = getQuarters(change);
        BigDecimal changeArray [] = change.divideAndRemainder(new BigDecimal(".25"));
        change = changeArray[1];
        BigDecimal dimes = getDimes(change);
        changeArray = change.divideAndRemainder(new BigDecimal(".10"));
        change = changeArray[1];
        BigDecimal nickles = getDimes(change);

        coinChange += quarters + " " + dimes + " " + nickles;
        this.balance = new BigDecimal("0.00");
        return coinChange;
    }

    public BigDecimal getQuarters(BigDecimal change){
        BigDecimal quarter = new BigDecimal(".25");

        BigDecimal [] quarterArray = change.divideAndRemainder(quarter);
        System.out.println(quarterArray[0]);
        return quarterArray[0];
    }

    public BigDecimal getDimes(BigDecimal change){
        BigDecimal dime = new BigDecimal(".10");
        BigDecimal [] dimeArray = change.divideAndRemainder(dime);
        return dimeArray[0];
    }


    public BigDecimal getNickles(BigDecimal change){
        BigDecimal nickle = new BigDecimal(".05");
        BigDecimal [] nickleArray = change.divideAndRemainder(nickle);
        return nickleArray[0];
    }

    public BigDecimal getItemPrice(String itemSlot){
        return vendingMachineItems.get(itemSlot).getPrice();

    }

    public void increaseBalance(BigDecimal price){
        this.balance = this.balance.add(price);
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public String getSound(String itemSlot){
        return vendingMachineItems.get(itemSlot).getSound();
    }

    public String getName(String itemSlot){
        return vendingMachineItems.get(itemSlot).getName();
    }

    public BigDecimal getPrice(String itemSlot){
        return vendingMachineItems.get(itemSlot).getPrice();
    }




}
