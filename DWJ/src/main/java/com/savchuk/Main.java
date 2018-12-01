package com.savchuk;

import com.savchuk.classes.ScannerMenu;
import com.savchuk.classes.TaxPayerManager;
import com.savchuk.command.Processing;

public class Main {
    public static void main(String[] args) {
        ScannerMenu scannerMenu = new ScannerMenu();
        TaxPayerManager taxPayerManager = new TaxPayerManager();
        Processing processing = new Processing();
        while (processing.checkCommands(scannerMenu.getCommand(), taxPayerManager));
    }
}
