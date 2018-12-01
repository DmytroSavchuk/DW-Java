package com.savchuk.classes;

import com.savchuk.enums.IncomeTypes;
import com.savchuk.enums.TaxTypes;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


public class Tax implements Serializable {
    private double taxAmount;
    private double taxRate;
    private TaxTypes type;
    private Period taxPeriod;
    private Set<IncomeTypes> lisOfIncomeSpreading;

    public Tax(double taxRate, Period taxPeriod, TaxTypes type) {
        this.taxRate = taxRate;
        this.type = type;
        this.taxPeriod = taxPeriod;
        this.lisOfIncomeSpreading = this.type.relationTaxIncome;
    }

    public Tax() {
        this.taxRate = 0;
        this.type = null;
        this.taxPeriod = null;
        this.lisOfIncomeSpreading = null;
    }

    public Set<IncomeTypes> getLisOfIncomeSpreading() {
        return lisOfIncomeSpreading;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public TaxTypes getType() {
        return type;
    }

    public void setType(TaxTypes type) {
        this.type = type;
    }

    public Period getTaxPeriod() {
        return taxPeriod;
    }

    public void setTaxPeriod(Period taxPeriod) {
        this.taxPeriod = taxPeriod;
    }

    public void addToListOfSpreading(IncomeTypes incomeType) {
        lisOfIncomeSpreading.add(incomeType);
    }

    private boolean checkIsInclude(IncomeTypes incomeType) {
        return lisOfIncomeSpreading.contains(incomeType);
    }

    public void calculateTaxAmount(List<Income> incomeList) {
        for (Income income : incomeList) {
            if (checkIsInclude(income.getType())) {
                taxAmount += (taxPeriod.getTimeInMonth()
                        / income.getPeriodOfReceipt().getTimeInMonth())
                        * income.getTotalValue()
                        * taxRate;
            }
        }
    }

    @Override
    public String toString() {
        return "Tax{" +
                "taxAmount=" + taxAmount +
                ", taxRate=" + taxRate +
                ", type=" + type +
                ", taxPeriod=" + taxPeriod +
                ", lisOfIncomeSpreading=" + lisOfIncomeSpreading +
                '}';
    }
}
