package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachineFileManager {
    private File machineItems = new File("vendingmachine.csv");
    private File output = new File("Log.txt");

    private Scanner fileScanner;

    public File getMachineItems() {
        return machineItems;
    }

    public Scanner getFileScanner() {
        return fileScanner;
    }


    public void writeToFile(String line){
        try ( PrintWriter pw = new PrintWriter(output) ) {
            pw.println(line);

        } catch (FileNotFoundException e) {

        }
    }


//    public void writeToFile(String line){
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd KK:mm:ss a");
//        String formatDateTime = now.format(formatter);
//        pw.println(line);
//        pw.close();
//
//    }

//    public void closeWriteFile(){
//        pw.close();
//    }

}
