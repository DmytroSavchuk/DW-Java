package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintFoundList implements Command {
    private static String regex = "/[pP]rint[fF]ound[lL]ist *$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            System.out.println(TaxPayerManager.getFindList());
            TaxPayerManager.getLogger().info("Found: \r\n" + TaxPayerManager.getFindList());
        }
    }
}