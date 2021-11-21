

package com.techelevator.application;


import com.techelevator.models.PurchaseOption;
import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;




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
            } else {
                System.out.println("Invalid Option");
            }

        }



    }




}








