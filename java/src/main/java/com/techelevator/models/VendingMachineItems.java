package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineItems extends VendingMachineFileManager{

    private Map<String , Items > vendingMachineItems = new HashMap<>();
    private Map<String , Items > populatedItemMap = populateMap();
    public Map<String , Items > populateMap() {
        Scanner fileScanner;
        File machineItems = super.getMachineItems();
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
        return vendingMachineItems;
    }

    public void displayItems(){

        for (Items item : populatedItemMap.values()){

            System.out.println("Slot:" + item.getSlot() + " Name:" + item.getName() + " Price:" + item.getPrice() + " Amount:" + item.getAmount());

        }

    }
    public Map<String, Items> getVendingMachineItems() {
        return this.populatedItemMap;
    }

    public int getAmount(String itemSlot){

        return populatedItemMap.get(itemSlot).getAmount();
    }

    public boolean isInMachine(String itemSlot){
        Items value = populatedItemMap.get(itemSlot);
        if (value != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean soldOutCheck(String purchasedItem){
        if (getAmount(purchasedItem) == 0){
            return true;
        } else {
            return false;
        }
    }

    public void updateItem(String itemSlot) {
        int decrease = populatedItemMap.get(itemSlot).getAmount()-1;
        //System.out.println(increase);
        populatedItemMap.get(itemSlot).setAmount(decrease);
        BigDecimal price = populatedItemMap.get(itemSlot).getPrice();


    }

    public BigDecimal getItemPrice(String itemSlot){
        return vendingMachineItems.get(itemSlot).getPrice();

    }


    public String getName(String itemSlot){
        return populatedItemMap.get(itemSlot).getName();
    }

}
