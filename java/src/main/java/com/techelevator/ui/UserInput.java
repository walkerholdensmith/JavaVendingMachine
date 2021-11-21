package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption()
    {

        UserOutput.homeScreenOptionsMessage();
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("1"))
        {
            return "display";
        }
        else if (option.equals("2"))
        {
            return "purchase";
        }
        else if (option.equals("3"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public static String moneyInserted(){
        UserOutput.moneyInsertedMessage();
        String selectedOption = scanner.nextLine();
        return selectedOption;
    }

    public static String purchaseOptions(BigDecimal balance) {

        UserOutput.purchaseOptionsMenu(balance);
        String option = scanner.nextLine();
        return option;

    }

    public static String itemSelection(){
        System.out.println("Please select and item based on slot number");
        String slotNumber = scanner.nextLine();
        return slotNumber;
    }




    
}
