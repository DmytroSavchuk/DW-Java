package com.savchuk.command;

import com.savchuk.classes.Period;
import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindByPeriod implements Command {
    private static String regex = "/[fF]ind[bB]y[pP]eriod +(?<NAME>\\w+), +(?<PERIOD1>\\d+\\.?\\d*), +(?<PERIOD2>\\d+\\.?\\d*)$";


    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            taxPayerManager.findByPeriod(taxPayerManager.findTaxPayer(m.group("NAME")),
                    new Period(Double.parseDouble(m.group("PERIOD1"))),
                    new Period(Double.parseDouble(m.group("PERIOD2"))));
            System.out.println(TaxPayerManager.getFindList());
            TaxPayerManager.getLogger().info("Found: " + TaxPayerManager.getFindList());
        }
    }
}