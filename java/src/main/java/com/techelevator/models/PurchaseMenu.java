package com.techelevator.models;

import com.techelevator.application.VendingMachine;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class PurchaseMenu {


//    PrintWriter pw;
//
//    {
//        try {
//            pw = new PrintWriter("Log.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

    private BigDecimal amountInserted = new BigDecimal("0.00");
    private BigDecimal moneyIn = new BigDecimal("0.00");
    LogFileHandling outputFile = new LogFileHandling();
    public void purchaseMenu() {
        this.amountInserted = amountInserted;
    }

    Scanner input = new Scanner(System.in);

    public BigDecimal getAmountInserted() {
        return this.amountInserted;
    }

    public void setAmountInserted(BigDecimal amountInserted) {
        this.amountInserted = amountInserted;
    }

    public void moneyInput(BigDecimal amount) {
        this.amountInserted = amountInserted.add(amount);
    }

    public String purchaseOption() {

        String option = input.nextLine();
        return option;
    }

    public void feedMoney() {

        System.out.println("Please insert a valid money amount: $1, $2, $5 or 10$");
        String amount = input.nextLine();
        System.out.println(amount);
        this.moneyIn = new BigDecimal(amount);
        this.amountInserted = this.amountInserted.add(moneyIn);
        this.setAmountInserted(this.amountInserted.add(moneyIn));
        this.setMoneyIn(this.moneyIn);
        System.out.println("Current money Provided: $" + this.amountInserted);


//

//            LocalDateTime currentTime =  LocalDateTime.now();
//            pw.write(currentTime + " FEED MONEY " + moneyIn + " " + this.amountInserted + "\n");


    }

    public BigDecimal getMoneyIn() {
        return this.moneyIn;
    }

    public void setMoneyIn(BigDecimal newAmount){
        this.moneyIn = newAmount;
    }

    public void displayPurchaseOption() {

        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");

    }
}


//    public void optionTwoFileWrite(LocalDateTime dateTime, String name, BigDecimal amountInserted, BigDecimal remainingMoney){
//
//        LocalDateTime currentTime =  LocalDateTime.now();
//        String line = (currentTime + name + amountInserted + " " + remainingMoney + "\n");
//        String line2 = (currentTime + name + amountInserted + " " + remainingMoney + "\n");
//        pw.write(line);
            //pw.write(line2);





//    }

//    public void closeFile(){
//        pw.close();
//    }
//
//
//
//
//
//}
