package com.savchuk.command;

import com.savchuk.classes.Income;
import com.savchuk.classes.Period;
import com.savchuk.classes.TaxPayerManager;
import com.savchuk.enums.IncomeTypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddIncome implements Command {
    private static String regex = "/[aA]dd[iI]ncome +(?<NAME>\\w+), +(?<VALUE>\\w+), (?<PERIOD>\\d+\\.?\\d*), +(?<TYPE>\\w+)$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            if (IncomeTypes.checkType(m.group("TYPE"))) {
                try {
                    taxPayerManager.
                            findTaxPayer(m.group("NAME"))
                            .getIncomeList()
                            .add(new Income(Double.parseDouble(m.group("VALUE")),
                                    new Period(Double.parseDouble(m.group("PERIOD"))),
                                    IncomeTypes.valueOf(m.group("TYPE"))));
                    TaxPayerManager.getLogger().info(m.group("NAME") + " added new income: "
                            + taxPayerManager.findTaxPayer(m.group("NAME")));
                }catch (Exception e)
                {
                    TaxPayerManager.getLogger().error(e.getMessage());
                }
            }
        }
    }
}