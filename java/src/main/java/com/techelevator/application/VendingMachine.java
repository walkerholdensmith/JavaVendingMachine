

package com.techelevator.application;

import com.techelevator.models.PurchaseOption;
import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine {
    private VendingMachineItems vendingMachineItems = new VendingMachineItems();
    public void run() {
        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            if (choice.equals("display")){
                vendingMachineItems.displayItems();
            } else if (choice.equals("purchase")){
                PurchaseOption purchaseOption = new PurchaseOption(vendingMachineItems);
                purchaseOption.displayPurchaseOption();
            } else if (choice.equals("exit")){
                break;
            }
        }
    }


}

