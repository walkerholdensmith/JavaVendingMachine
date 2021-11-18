package com.techelevator.models;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseMenu {
    private BigDecimal amountInserted = new BigDecimal("0.00");
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
        BigDecimal moneyIn =  new BigDecimal(amount);
        amountInserted.add(moneyIn);
        System.out.println("Amount Inserted: $" + amount);


    }

}
