package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteTaxPayer implements Command {
    private static String regex = "/[dD]elete[tT]ax[pP]ayer +(?<NAME>\\w+)$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            if (taxPayerManager.deleteTaxPayer(taxPayerManager.findTaxPayer(m.group("NAME")))) {
                TaxPayerManager.getLogger().info(m.group("NAME") + " deleted");
            }
            else {
                System.out.println(m.group("NAME") + " not found!");
                TaxPayerManager.getLogger().error(m.group("NAME") + " not found!");
            }
        }
    }
}
