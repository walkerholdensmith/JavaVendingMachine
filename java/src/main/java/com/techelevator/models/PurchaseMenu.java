package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserOutput;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PurchaseMenu  {
    private BigDecimal amountInserted = new BigDecimal("0.00");

    public void purchaseMenu(){
        this.amountInserted = amountInserted;
    }

    Scanner input = new Scanner(System.in);

    public BigDecimal getAmountInserted() {
        return amountInserted;
    }

    public void setAmountInserted(BigDecimal amountInserted) {
        this.amountInserted = amountInserted;
    }

    public void moneyInput(BigDecimal amount){
        this.amountInserted = amountInserted.add(amount);
    }
    public String purchaseOption(){

        String option = input.nextLine();
        return option;
    }

    public void feedMoney(){

            System.out.println("Please insert a valid money amount: $1, $2, $5 or 10$");
            String amount = input.nextLine();
            System.out.println(amount);
            BigDecimal moneyIn = new BigDecimal(amount);
            this.amountInserted = this.amountInserted.add(moneyIn);
            System.out.println("Current money Provided: $" + this.amountInserted);
            LocalDateTime currentTime =  LocalDateTime.now();
            VendingMachine vendingMachine = new VendingMachine();
            vendingMachine.writeToFile(currentTime + " FEED MONEY " + moneyIn + " " + this.amountInserted);

//           try(PrintWriter pw = new PrintWriter("Log.txt")){
//               LocalDateTime currentTime =  LocalDateTime.now();
//               pw.println(currentTime + " FEED MONEY " + moneyIn + " " + this.amountInserted);
//           }catch (FileNotFoundException e){}

    }

    public void displayPurchaseOption() {

        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");

    }





}
