package com.techelevator.application;

import com.techelevator.models.PurchaseMenu;
import com.techelevator.models.VendingMachineFunctions;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.util.Scanner;

public class VendingMachine 
{
    public void run()
    {
        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            VendingMachineFunctions vendingItems = new VendingMachineFunctions();

            if(choice.equals("display"))
            {
                // display the vending machine slots

                vendingItems.displayItems();
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase

                PurchaseMenu purchaseMenu = new PurchaseMenu();
                purchaseMenu.displayPurchaseOption();
                String option = purchaseMenu.purchaseOption();

                if(option.equals("1")) {
                    purchaseMenu.feedMoney();
                } else if (option.equals("2")) {
                    vendingItems.displayItems();
                    String purchasedItem = vendingItems.itemSelection();
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
