package com.techelevator;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.Beverage;
import com.techelevator.models.VendingMachineFunctions;

public class VendingMachineCLI 
{
    public static void main(String[] args) 
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.run();

        //VendingMachineFunctions test = new VendingMachineFunctions();
        //System.out.println(test.getTest());

    }
    
}
