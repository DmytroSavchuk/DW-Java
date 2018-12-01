package com.savchuk.command;

import com.savchuk.classes.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculateTaxAmount implements Command {
    private static String regex = "/[cC]alculate[tT]ax[aA]mount +(?<NAME>\\w+)$|" +
            "/[cC]alculate[tT]ax[aA]mount[aA]ll *$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            if (!(m.group("NAME") == null)) {
                try {
                    taxPayerManager.findTaxPayer(m.group("NAME")).getTaxList().forEach(
                            tax -> tax.calculateTaxAmount(taxPayerManager.findTaxPayer(m.group("NAME")).getIncomeList()));
                    TaxPayerManager.getLogger().info("Calculated taxAmount for " + m.group("NAME"));
                } catch (Exception e) {
                    TaxPayerManager.getLogger().error(e.getMessage());
                }
            } else {
                try {
                    TaxPayerManager.getTaxPayers()
                            .forEach(taxPayer -> taxPayer.getTaxList()
                                    .forEach(tax -> tax.calculateTaxAmount(taxPayer.getIncomeList())));
                    TaxPayerManager.getLogger().info("Calculated taxAmount for all taxPayers");
                } catch (Exception e) {
                    TaxPayerManager.getLogger().error(e.getMessage());
                }
            }
        }
    }
}