package com.techelevator.models;

import com.techelevator.application.VendingMachine;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class PurchaseOption extends VendingMachineItems{


    private BigDecimal balance = new BigDecimal("0.00");
    private BigDecimal moneyIn = new BigDecimal("0.00");
    private String option = "";
    private String purchasedItem = "";
    private BigDecimal remainingMoney = new BigDecimal("0.00");
    private Scanner input = new Scanner(System.in);
    VendingMachineFileManager outFile = new VendingMachineFileManager();

    private PrintWriter pw;

//    {
//        try {
//            pw = new PrintWriter("Log.txt");
//        } catch (FileNotFoundException fileNotFoundException) {
//            fileNotFoundException.printStackTrace();
//        }
//    }

    public void displayPurchaseOption() {

        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println("\nCurrent Money Provided: $" + this.balance);
        System.out.println("Please enter a valid option: ");
        this.option = input.nextLine();
        if (this.option.equals("1")){
            runOptionOne();


        } else if (this.option.equals("2")){
            runOptionTwo();
        } else if (this.option.equals("3")){
            runOptionThree();

        }

    }
    //prints super classes method to show vending options
    public void runOptionOne(){
        boolean stillAdding = true;
        while (stillAdding){
            feedMoney();
            displayPurchaseOption();
            String line = " FEED MONEY \\" + moneyIn + " \\" + balance;
            outFile.writeToFile(line);
            if(!this.option.equals("1")) {

                stillAdding = false;
            }
        }
    }

    public void runOptionTwo(){
        boolean stillSelecting = true;
        while(stillSelecting){
            super.displayItems();
            this.purchasedItem = itemSelection();
            System.out.println(super.getAmount(this.purchasedItem));
            if (super.soldOutCheck(this.purchasedItem)){
                System.out.println("SOLD OUT!");
                super.displayItems();
                displayPurchaseOption();
            }

            super.updateItem(this.purchasedItem);
            this.balance = this.balance.subtract(super.getItemPrice(this.purchasedItem));
            displayPurchaseOption();

            String line =  super.getName(this.purchasedItem) +" \\" + this.balance + " \\" + moneyIn.subtract(balance);
            outFile.writeToFile(line);

            if(!this.option.equals("2")) {
                stillSelecting = false;
            }
        }
    }

    public void runOptionThree(){
        System.out.println(createChange(this.balance, this.moneyIn));
        this.setMoneyIn(new BigDecimal("0.00"));

    }


    public String itemSelection() {
        System.out.println("Please select and item based on slot number");
        String slotNumber = input.nextLine();
        return slotNumber;
    }

    public void setMoneyIn(BigDecimal moneyIn) {
        this.moneyIn = moneyIn;
    }

    public void feedMoney(){
        System.out.println("Please insert a valid money amount: $1, $2, $5 or 10$");
        String amount = input.nextLine();
        System.out.println(amount);
        this.moneyIn = new BigDecimal(amount);
        this.balance = this.balance.add(moneyIn);
        //this.setAmountInserted(this.amountInserted.add(moneyIn));     Having this here added a double count after adding money
        this.setMoneyIn(this.moneyIn);
        System.out.println("Current money Provided: $" + this.balance);

    }
    public String createChange(BigDecimal price, BigDecimal amount){
        String coinChange = "Quarters: ";
        BigDecimal change = amount.subtract(price);

        //System.out.println(change);
        BigDecimal quarters = getQuarters(change);
        BigDecimal changeArray [] = change.divideAndRemainder(new BigDecimal(".25"));
        change = changeArray[1];
        BigDecimal dimes = getDimes(change);
        changeArray = change.divideAndRemainder(new BigDecimal(".10"));
        change = changeArray[1];
        BigDecimal nickles = getNickles(change);

        coinChange += quarters + " Dimes: " + dimes + " Nickles: " + nickles;
        this.balance = new BigDecimal("0.00");
        return coinChange;
    }

    public BigDecimal getQuarters(BigDecimal change){
        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal [] quarterArray = change.divideAndRemainder(quarter);
        return quarterArray[0];
    }

    public BigDecimal getDimes(BigDecimal change){
        BigDecimal dime = new BigDecimal(".10");
        BigDecimal [] dimeArray = change.divideAndRemainder(dime);
        return dimeArray[0];
    }


    public BigDecimal getNickles(BigDecimal change){
        BigDecimal nickle = new BigDecimal(".05");
        BigDecimal [] nickleArray = change.divideAndRemainder(nickle);
        return nickleArray[0];
    }

}
