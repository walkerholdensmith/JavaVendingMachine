package com.techelevator.application;

import com.techelevator.models.LogFileHandling;
import com.techelevator.models.PurchaseMenu;
import com.techelevator.models.VendingMachineFunctions;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;



import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachine
{

PrintWriter pw;
    public void run() {


    {
        try {
            pw = new PrintWriter("Log.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


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
                while (!checkIsValid(option)){
                    purchaseMenu.displayPurchaseOption();
                    option = purchaseMenu.purchaseOption();
                }
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
                    System.out.println(vendingItems.createChange(totalPrice, amountInserted));
                    System.out.println(vendingItems.getBalance());
                    purchaseMenu.setAmountInserted(new BigDecimal("0.00"));
                    pw.println(">\\`\\`\\`");
                    pw.close();
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

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd KK:mm:ss a");
            String formatDateTime = now.format(formatter);

            DateTimeFormatter hoursSeconds = DateTimeFormatter.ofPattern("KK:mm:ss a", Locale.ENGLISH);

            pw.println(">" + formatDateTime +  " FEED MONEY \\" + purchaseMenu.getMoneyIn() + " \\" + purchaseMenu.getAmountInserted());

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
            while(!vendingItems.isInMachine(purchasedItem)){
                System.out.println("\nInvalid selection!");
                purchaseMenu.displayPurchaseOption();
                option = purchaseMenu.purchaseOption();
            }
            if (vendingItems.getAmount(purchasedItem) == 0){
                System.out.println("SOLD OUT");
                vendingItems.displayItems();
                purchaseMenu.displayPurchaseOption();
                option = purchaseMenu.purchaseOption();
            }

            amountInserted = purchaseMenu.getAmountInserted();
            vendingItems.updateItem(purchasedItem, amountInserted);
            totalPrice = totalPrice.add(vendingItems.getItemPrice(purchasedItem));
            if (amountInserted.compareTo(totalPrice) == 1){

                remainingMoney = amountInserted.subtract(totalPrice);
                purchaseMenu.setAmountInserted(remainingMoney);
                System.out.println(vendingItems.getName(purchasedItem) +  " " +vendingItems.getPrice(purchasedItem) + " " + remainingMoney);
                System.out.println(vendingItems.getSound(purchasedItem));
                LocalDateTime currentTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss a");
                String formatDateTime = currentTime.format(formatter);
                String line = (">" + formatDateTime + " " + vendingItems.getName(purchasedItem) +" \\" + amountInserted + " \\" + remainingMoney);
                pw.println(line);

            } else {
                System.out.println("Not Enough Money Inserted");
            }
            purchaseMenu.displayPurchaseOption();
            option = purchaseMenu.purchaseOption();
            purchaseMenu.setAmountInserted(remainingMoney);

            if (option.equals("1")){
                optionOne(purchaseMenu, option);
            }
            else if(!option.equals("2")) {
                stillSelecting = false;
            } else if(option.equals("2")) {
                totalPrice = new BigDecimal("0.00");
            }
        }
        dataTransfer.add(option);
        dataTransfer.add(totalPrice);
        dataTransfer.add(amountInserted);
        return dataTransfer;
    }


    public Boolean checkIsValid(String option){
        if (!option.equals("1") || !option.equals("2") || !option.equals("3")){
            return true;
        } else {
            return false;
        }
    }

}



















