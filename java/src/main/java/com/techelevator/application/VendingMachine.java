

package com.techelevator.application;


import com.techelevator.models.PurchaseOption;
import com.techelevator.models.VendingMachineFileManager;
import com.techelevator.models.VendingMachineItems;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine {
    private VendingMachineItems vendingMachineItems = new VendingMachineItems();
    VendingMachineFileManager outFile = new VendingMachineFileManager();

    public void run() {

        while(true) {

            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            if (choice.equals("display")){
                vendingMachineItems.displayItems();
            } else if (choice.equals("purchase")){
                PurchaseOption purchaseOption = new PurchaseOption(vendingMachineItems, outFile);
                purchaseOption.displayPurchaseOption();
            } else if (choice.equals("exit")){
                outFile.closeWriteFile();
                break;
            } else {
                System.out.println("Invalid Option");
            }
        }

    }




}








