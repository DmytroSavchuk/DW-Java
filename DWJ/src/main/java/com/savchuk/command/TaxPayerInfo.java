package com.savchuk.command;

import com.savchuk.classes.TaxPayer;
import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxPayerInfo implements Command {
    private static String regex = "/info +(?<NAME>\\w+)$" + "|" +
            "/info *$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            if (m.group("NAME") != null) {
               taxPayerManager.findTaxPayer(m.group("NAME")).info();
            }else
            {
                TaxPayerManager.getTaxPayers().forEach(TaxPayer::info);
            }
            TaxPayerManager.getLogger().info("Printed info about taxPayers");
        }
    }
}