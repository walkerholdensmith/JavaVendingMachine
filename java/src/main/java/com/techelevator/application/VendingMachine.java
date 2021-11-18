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


            if(choice.equals("display"))
            {
                // display the vending machine slots
                VendingMachineFunctions displayInformation = new VendingMachineFunctions();
                displayInformation.displayItems();
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                UserOutput.displayPurchaseMenu();
                PurchaseMenu purchaseMenu = new PurchaseMenu();
                String option = purchaseMenu.purchaseOption();
                if (option.equals("1")){
                    purchaseMenu.feedMoney();
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
