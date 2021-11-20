package com.techelevator.models;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFileHandling{
    PrintWriter pw;
    {
        try {
            pw = new PrintWriter("Log.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void optionOneFileWrite(BigDecimal moneyIn, BigDecimal amountInserted){
        LocalDateTime currentTime =  LocalDateTime.now();
        pw.write(currentTime + " FEED MONEY " + moneyIn + " " + amountInserted + "\n");

    }

    public void optionTwoFileWrite(String name, BigDecimal remainingMoney, BigDecimal amountInserted) {

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = currentTime.format(formatter);
        String line = (currentTime + name + amountInserted + " " + remainingMoney + "\n");
        pw.write(line);
    }

    public void closeFile(){
        pw.close();
    }

}
