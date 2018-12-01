package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindByValue implements Command {
    private static String regex = "/[fF]ind[bB]y[vV]alue +(?<NAME>\\w+), +(?<VALUE1>\\d+\\.?\\d*), +(?<VALUE2>\\d+\\.?\\d*)$";


    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            taxPayerManager.findByAmount(taxPayerManager.findTaxPayer(m.group("NAME")),
                    Double.parseDouble(m.group("VALUE1")),
                    Double.parseDouble(m.group("VALUE2")));
            System.out.println(TaxPayerManager.getFindList());
            TaxPayerManager.getLogger().info("Found: " + TaxPayerManager.getFindList());
        }
    }
}