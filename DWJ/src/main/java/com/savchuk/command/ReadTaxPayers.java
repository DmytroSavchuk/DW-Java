package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadTaxPayers implements Command {
    private static String regex = "/[rR]ead[tT]ax[pP]ayers +(?<NAME>\\w+)\\s*$|" +
            "/[rR]ead[tT]ax[pP]ayers[lL]ist +(?<LISTNAME>\\{.+}\\w+)\\s*$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            if (!(m.group("NAME") == null)) {
                taxPayerManager.readPayerFromFile(m.group("NAME"));
            }
            else if(!(m.group("LISTNAME") == null))
            {
                taxPayerManager.readPayersListFromFile(m.group("LISTNAME"));
            }
            TaxPayerManager.getLogger().info("Read taxPayers from file");
        }
    }
}
