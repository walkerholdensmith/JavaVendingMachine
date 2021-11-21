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

    PrintWriter pw;

    {
        try {
            pw = new PrintWriter(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public File getMachineItems() {
        return machineItems;
    }

    public Scanner getFileScanner() {
        return fileScanner;
    }

    public void writeToFile(String line){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd KK:mm:ss a");
        String formatDateTime = now.format(formatter);
        pw.println(">" + formatDateTime + " " + line);
    }

    public void closeWriteFile(){
        pw.close();
    }

}



