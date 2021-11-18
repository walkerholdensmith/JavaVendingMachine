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

                if(option.equals("1")) {
                    purchaseMenu.feedMoney();
                } else if (option.equals("2")) {
                    vendingItems.displayItems();
                    String purchasedItem = vendingItems.itemSelection();
                    BigDecimal amountInserted = purchaseMenu.getAmountInserted();
                    System.out.println(amountInserted);
                    vendingItems.updateItem(purchasedItem, amountInserted);
                    System.out.println(vendingItems.getBalance());


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
