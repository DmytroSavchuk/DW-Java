package com.savchuk.classes;

import java.util.Scanner;

public class ScannerMenu{
    private  Scanner menuScanner = new Scanner(System.in);
    public  Scanner getMenuScanner() {
        return menuScanner;
    }
    public String getCommand(){
        return menuScanner.nextLine();
    }
}
