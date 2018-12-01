package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;
import com.savchuk.enums.TaxTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindByType implements Command {
    private static String regex = "/[fF]ind[bB]y[tT]ype +(?<NAME>\\w+), +(?<TYPE>\\w+)$";


    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            taxPayerManager.findByType(taxPayerManager.findTaxPayer(m.group("NAME")), TaxTypes.valueOf(m.group("TYPE")));
            System.out.println(TaxPayerManager.getFindList());
            TaxPayerManager.getLogger().info("Found: " + TaxPayerManager.getFindList());
        }
    }
}