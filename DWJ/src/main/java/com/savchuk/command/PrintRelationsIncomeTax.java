package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintRelationsIncomeTax implements Command  {
    private static String regex = "/[pP]rint[rR]elations +(?<NAME>\\w+)$";
    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {
        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            taxPayerManager.findTaxPayer(m.group("NAME"))
                    .getTaxList().forEach(tax -> System.out.println(tax.getType()
                    + ": " + tax.getLisOfIncomeSpreading()));
            TaxPayerManager.getLogger().info("Printed relations list");
        }
    }
}
