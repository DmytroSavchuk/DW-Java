package com.savchuk.command;

import com.savchuk.classes.TaxPayer;
import com.savchuk.classes.TaxPayerManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddTaxPayer implements Command  {
    private static String regex = "/[aA]dd[tT]ax[pP]ayer +(?<NAME>\\w+)$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            taxPayerManager.addTaxPayer(new TaxPayer(m.group("NAME")));
            TaxPayerManager.getLogger().info("Added new taxPayer: " + m.group("NAME"));
        }
    }
}
