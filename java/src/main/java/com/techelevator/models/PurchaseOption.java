package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;

public class PurchaseOption {


    private BigDecimal balance = new BigDecimal("0.00");
    private BigDecimal moneyIn = new BigDecimal("0.00");
    private String option = "";
    private String purchasedItem = "";
    private BigDecimal remainingMoney = new BigDecimal("0.00");
    private Scanner input = new Scanner(System.in);
    private VendingMachineFileManager outFile = new VendingMachineFileManager();
    private VendingMachineItems populatedMap;
    private UserOutput userOutput = new UserOutput();
    private UserInput userInput = new UserInput();

    private PrintWriter pw;

    public PurchaseOption(VendingMachineItems populatedMap){
        this.populatedMap = populatedMap;

    }

    public void displayPurchaseOption() {

        this.option = userInput.purchaseOptions(this.balance);
        if (this.option.equals("1")){
            runOptionOne();
        } else if (this.option.equals("2")){
            runOptionTwo();
        } else if (this.option.equals("3")){
            runOptionThree();
        } else {
            userOutput.invalidOption();
            displayPurchaseOption();
        }

    }
    //prints super classes method to show vending options
    public void runOptionOne(){
        boolean stillAdding = true;
        while (stillAdding){
            feedMoney();
            displayPurchaseOption();
            if(!this.option.equals("1")) {
                stillAdding = false;
            }
        }
    }

    public void runOptionTwo(){
        boolean stillSelecting = true;
        String line = "";
        while(stillSelecting){

            populatedMap.displayItems();
            this.purchasedItem = userInput.itemSelection();
            if(!populatedMap.isInMachine(this.purchasedItem)) {

                System.out.println("Not in Machine");
                displayPurchaseOption();
            }
           if (populatedMap.soldOutCheck(this.purchasedItem)){

                System.out.println("SOLD OUT!");
                populatedMap.displayItems();
                displayPurchaseOption();
            }
          if(this.balance.compareTo(populatedMap.getItemPrice(purchasedItem)) == 1) {


                populatedMap.updateItem(this.purchasedItem);
                this.balance = (this.balance.subtract(populatedMap.getItemPrice(this.purchasedItem)));

                line =  populatedMap.getName(this.purchasedItem) +" \\$" + this.moneyIn.setScale(2, RoundingMode.HALF_UP) + " \\$" + this.balance ;
                outFile.writeToFile(line);
                this.moneyIn = this.moneyIn.subtract(populatedMap.getItemPrice(purchasedItem));
            } else {
                userOutput.notEnoughMoney();
            }
            displayPurchaseOption();

            if(!this.option.equals("2")) {
                stillSelecting = false;
            }
        }

    }

    public void runOptionThree(){
        System.out.println(this.balance);
        outFile.writeToFile("CREATE CHANGE: \\$" + this.balance + " \\$" + this.balance.subtract(this.balance));
        String line = (createChange(this.balance, this.moneyIn.subtract(this.balance)));
        System.out.println(line);
        this.setMoneyIn(new BigDecimal("0.00"));
        outFile.closeWriteFile();
    }

    public void setMoneyIn(BigDecimal moneyIn) {
        this.moneyIn = moneyIn;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void feedMoney(){

        String amount = userInput.moneyInserted();
        boolean rightAmount = isValidDollar(amount);
        while (!rightAmount) {
            System.out.println("Enter a valid amount");

            amount = input.nextLine();
            rightAmount = isValidDollar(amount);
        }
        BigDecimal numAmount = new BigDecimal(amount);
        this.moneyIn = numAmount;
        this.balance = this.balance.add(moneyIn);
        this.setMoneyIn(this.moneyIn);
        userOutput.currentMoneyProvided(this.balance);
        String line = "FEED MONEY \\$" + moneyIn.setScale(2,RoundingMode.HALF_UP) + " \\$" + balance;
        outFile.writeToFile(line);

    }

    public boolean isValidDollar(String amount) {

        boolean isTrue = false;

        if(amount.equals("10")){
            isTrue = true;
        }
        else if(amount.equals("5")) {
            isTrue = true;
        }
        else if(amount.equals("2")) {
            isTrue = true;
        }
        else if(amount.equals("1")) {
            isTrue = true;
        } else {
            isTrue = false;
        }
        return isTrue;
    }

    public boolean isANum(String amount){
        boolean isANum = true;
        for (int i = 0; i < amount.length(); i++) {
            char c = amount.charAt(i);
            if (c < '0' || c > '9') {
                isANum = false;
            }
        }
        return isANum;
    }

    public String createChange(BigDecimal price, BigDecimal amount){
        String coinChange = "Quarters: ";
        BigDecimal change = this.balance;

        //System.out.println(change);
        BigDecimal quarters = getQuarters(this.balance);
        BigDecimal changeArray [] = this.balance.divideAndRemainder(new BigDecimal(".25"));
        this.balance = changeArray[1];
        BigDecimal dimes = getDimes(this.balance);
        changeArray = this.balance.divideAndRemainder(new BigDecimal(".10"));
        this.balance = changeArray[1];
        BigDecimal nickles = getNickles(this.balance);

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