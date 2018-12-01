package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;
import com.savchuk.enums.IncomeTypes;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintIncomeTypes implements Command  {
    private static String regex = "/[pP]rint[iI]ncome[tT]ypes *$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {
        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            System.out.println(Arrays.toString(IncomeTypes.values()));
            TaxPayerManager.getLogger().info("Printed: \r\n" + Arrays.toString(IncomeTypes.values()));
        }
    }
}
