package com.techelevator.application;

import com.techelevator.models.PurchaseMenu;
import com.techelevator.models.VendingMachineFunctions;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;


import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine
{
    public void run()
    {

        VendingMachineFunctions vendingItems = new VendingMachineFunctions();
        vendingItems.populateMap();
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        BigDecimal amountInserted = new BigDecimal("0.00");
        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            //String choice = UserInput.getHomeScreenOption();
            //VendingMachineFunctions vendingItems = new VendingMachineFunctions();

            if(choice.equals("display"))
            {
                // display the vending machine slots

                vendingItems.displayItems();
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                purchaseMenu.displayPurchaseOption();
                String option = purchaseMenu.purchaseOption();
                String purchasedItem = "";
                if(option.equals("1")) {
                    boolean stillAdding = true;

                    while(stillAdding) {
                        purchaseMenu.feedMoney();
                        purchaseMenu.displayPurchaseOption();
                        option = purchaseMenu.purchaseOption();
                        if(!option.equals("1")) {
                            stillAdding = false;
                        }
                    }
                }
                if (option.equals("2")) {
                    vendingItems.displayItems();
                    purchasedItem = vendingItems.itemSelection();
                    amountInserted = purchaseMenu.getAmountInserted();
                    vendingItems.updateItem(purchasedItem, amountInserted);
                    purchaseMenu.displayPurchaseOption();
                    option = purchaseMenu.purchaseOption();
                }

                if (option.equals("3")){
                    BigDecimal itemPrice = vendingItems.getItemPrice(purchasedItem);
                    System.out.println(vendingItems.createChange(itemPrice, amountInserted));
                }

            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }







}



















