package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Processing {
    private static List<Command> commandList = new ArrayList<>();

    static {
        commandList.addAll(Arrays.asList(
                new AddTaxPayer(),
                new DeleteTaxPayer(),
                new PrintTaxPayers(),
                new WriteTaxPayers(),
                new ReadTaxPayers(),
                new PrintIncomeTypes(),
                new PrintTaxTypes(),
                new AddIncome(),
                new AddTax(),
                new CalculateTaxAmount(),
                new PrintRelationsIncomeTax(),
                new FindByPeriod(),
                new FindByRate(),
                new FindByType(),
                new FindByValue(),
                new Help(),
                new TaxPayerInfo(),
                new PrintFoundList()
        ));
    }

    public boolean checkCommands(String command, TaxPayerManager taxPayerManager) {
        for (Command c : commandList) {
            c.doCommand(command, taxPayerManager);
        }
        return true;
    }
}
