package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintTaxPayers implements Command  {
    private static String regex = "/[pP]rint[tT]ax[pP]ayers *$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {
        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            taxPayerManager.printTaxPayersList();
            TaxPayerManager.getLogger().info("Printed taxPayers list");
        }
    }
}
