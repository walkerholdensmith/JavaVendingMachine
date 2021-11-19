package com.techelevator.application;

import com.techelevator.models.PurchaseMenu;
import com.techelevator.models.VendingMachineFunctions;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine
{
    public void run()
    {

        VendingMachineFunctions vendingItems = new VendingMachineFunctions();
        vendingItems.populateMap();
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        BigDecimal amountInserted = new BigDecimal("0.00");
        List<Object> dataTransferList = new ArrayList<Object>();



        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {

                vendingItems.displayItems();
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                purchaseMenu.displayPurchaseOption();
                String option = purchaseMenu.purchaseOption();

                BigDecimal totalPrice = new BigDecimal("0.00");
                if(option.equals("1")) {
                    option = optionOne(purchaseMenu, option);
                }

                if (option.equals("2")) {
                    dataTransferList = optionTwo(vendingItems, purchaseMenu, totalPrice, option, amountInserted, dataTransferList );
                    option = dataTransferList.get(0).toString();
                    totalPrice = new BigDecimal(dataTransferList.get(1).toString());
                    amountInserted = new BigDecimal(dataTransferList.get(2).toString());

                }

                if (option.equals("3")){
                    //BigDecimal itemPrice = vendingItems.getItemPrice(purchasedItem);
                    System.out.println(vendingItems.createChange(totalPrice, amountInserted));
                    System.out.println(vendingItems.getBalance());
                    purchaseMenu.setAmountInserted(new BigDecimal("0.00"));
                }

            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }

    public String optionOne(PurchaseMenu purchaseMenu, String option){
        boolean stillAdding = true;

        while(stillAdding) {
            purchaseMenu.feedMoney();
            purchaseMenu.displayPurchaseOption();
            option = purchaseMenu.purchaseOption();
            if(!option.equals("1")) {
                stillAdding = false;
            }
        }

        return option;
    }

    public List<Object> optionTwo(VendingMachineFunctions vendingItems, PurchaseMenu purchaseMenu, BigDecimal totalPrice, String option,BigDecimal amountInserted, List<Object> dataTransfer ){
        String purchasedItem = "";
        boolean stillSelecting = true;
        BigDecimal remainingMoney = new BigDecimal("0.00");
        while (stillSelecting) {
            vendingItems.displayItems();
            purchasedItem = vendingItems.itemSelection();
            amountInserted = purchaseMenu.getAmountInserted();
            vendingItems.updateItem(purchasedItem, amountInserted);
            totalPrice = totalPrice.add(vendingItems.getItemPrice(purchasedItem));
            if (amountInserted.compareTo(totalPrice) == 1){
                remainingMoney = amountInserted.subtract(totalPrice);

                System.out.println(vendingItems.getName(purchasedItem) +  " " +vendingItems.getPrice(purchasedItem) + " " + remainingMoney);
                System.out.println(vendingItems.getSound(purchasedItem));
            } else {
                System.out.println("Not Enough Money Inserted");
            }

//            try(PrintWriter pw = new PrintWriter("Log.txt")){
//
//                LocalDateTime currentTime =  LocalDateTime.now();
//                pw.println(currentTime + " " +vendingItems.getName(purchasedItem) + " " + amountInserted + " " + remainingMoney);
//            }catch (FileNotFoundException e){}

            purchaseMenu.displayPurchaseOption();
            option = purchaseMenu.purchaseOption();
            purchaseMenu.setAmountInserted(remainingMoney);
            if (option.equals("1")){
                optionOne(purchaseMenu, option);
            }
            else if(!option.equals("2")) {
                stillSelecting = false;
            }
        }
        dataTransfer.add(option);
        dataTransfer.add(totalPrice);
        dataTransfer.add(amountInserted);
        return dataTransfer;
    }

    public void writeToFile(String line) {
        File outputFile = new File("Log.txt");

        try(Scanner fileScanner = new Scanner(outputFile)) {
            PrintWriter pw = new PrintWriter(outputFile);
            pw.println(line);
            System.out.println("Something");

        } catch (FileNotFoundException e) {
            System.out.println("no file");
        }
    }


}



















