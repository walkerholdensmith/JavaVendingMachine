package com.techelevator.ui;




import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void currentMoneyProvided(BigDecimal moneyProvided){
        System.out.println("Current money Provided: $" + moneyProvided);
    }

    public static void notEnoughMoney(){
        System.out.println("Not enough money inserted");
    }

    public static void invalidOption(){
        System.out.println("Invalid Option");
    }

    public static void homeScreenOptionsMessage(){
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void moneyInsertedMessage() {
        System.out.println("Please insert a valid money amount: $1, $2, $5 or 10$");
    }

    public static void purchaseOptionsMenu(BigDecimal balance){
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println("\nCurrent Money Provided: \\$" + balance);
        System.out.println("Please enter a valid option: ");
    }


}
