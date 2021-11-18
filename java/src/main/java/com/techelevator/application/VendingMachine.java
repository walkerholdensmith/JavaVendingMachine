package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

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
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                UserOutput.displayPurchaseMenu();
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }





<<<<<<< HEAD
=======












>>>>>>> fe986e8c32aeed68ce69efa4a58cb03f38ad39fe
    
}
