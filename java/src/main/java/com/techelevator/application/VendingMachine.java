package com.techelevator.application;

import com.techelevator.models.LogFileHandling;
import com.techelevator.models.PurchaseMenu;
import com.techelevator.models.PurchaseOption;
import com.techelevator.models.VendingMachineItems;
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

public class VendingMachine {


    public void run() {
        VendingMachineItems vendingMachineItems = new VendingMachineItems();
        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            if (choice.equals("display")){
                vendingMachineItems.displayItems();
            } else if (choice.equals("purchase")){
                PurchaseOption purchaseOption = new PurchaseOption();
                purchaseOption.displayPurchaseOption();
            } else if (choice.equals("exit")){
                break;
            }

        }
<<<<<<< HEAD
=======
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
>>>>>>> 2180d80b0597a303e8386b183d94d2280e2ffae5


        }




}



















