package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindByRate implements Command {
    private static String regex = "/[fF]ind[bB]y[rR]ate +(?<NAME>\\w+), +(?<RATE1>\\d+\\.?\\d*), +(?<RATE2>\\d+\\.?\\d*)$";


    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            taxPayerManager.findByRate(taxPayerManager.findTaxPayer(m.group("NAME")),
                    Double.parseDouble(m.group("RATE1")),
                    Double.parseDouble(m.group("RATE2")));
            System.out.println(TaxPayerManager.getFindList());
            TaxPayerManager.getLogger().info("Found: " + TaxPayerManager.getFindList());
        }
    }
}