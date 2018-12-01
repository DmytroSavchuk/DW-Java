package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteTaxPayers implements Command {
    private static String regex = "/[wW]rite[tT]ax[pP]ayers *$" + "|" +
            "/[wW]rite[tT]ax[pP]ayers +(?<NAME>\\w+)$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            if (m.group("NAME") != null) {
                taxPayerManager.writePayersListInFile();
            } else if (m.group("NAME") == null) {
                taxPayerManager.writePayerInFile(taxPayerManager.findTaxPayer(m.group("NAME")));
            }
            TaxPayerManager.getLogger().info("Recording of taxPayers to a file");
        }
    }
}
