package com.savchuk.command;

import com.savchuk.classes.Period;
import com.savchuk.classes.Tax;
import com.savchuk.classes.TaxPayerManager;
import com.savchuk.enums.TaxTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddTax implements Command {
    private static String regex = "/[aA]dd[tT]ax +(?<NAME>\\w+), +(?<RATE>\\d+\\.?\\d*), (?<PERIOD>\\d+\\.?\\d*), +(?<TYPE>\\w+)$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            if (TaxTypes.checkType(m.group("TYPE"))) {
                try {

                    taxPayerManager.
                            findTaxPayer(m.group("NAME"))
                            .getTaxList()
                            .add(new Tax(Double.parseDouble(m.group("RATE")),
                                    new Period(Double.parseDouble(m.group("PERIOD"))),
                                    TaxTypes.valueOf(m.group("TYPE"))));
                    TaxPayerManager.getLogger().info(taxPayerManager.
                            findTaxPayer(m.group("NAME")).getTaxList());
                }catch (Exception e)
                {
                    TaxPayerManager.getLogger().error(e.getMessage());
                }
            }
        }
    }
}