package com.savchuk.classes;

import java.io.Serializable;
import java.util.*;

public class TaxPayer implements Serializable {
    private String nameOfTaxPayer;
    private List<Income> incomeList = new ArrayList<>();
    private List<Tax> taxList = new ArrayList<>();

    private static Comparator<Tax> taxComparatorForAmount = Comparator.comparingDouble(Tax::getTaxAmount);
    private static Comparator<Tax> taxComparatorForPeriod = Comparator.comparingDouble(o -> o.getTaxPeriod().getTimeInMonth());
    private static Comparator<Tax> taxComparatorForType = Comparator.comparing(o -> o.getType().toString());

    public TaxPayer(String nameOfTaxPayer) {
        this.nameOfTaxPayer = nameOfTaxPayer;
    }

    public List<Income> getIncomeList() {
        return incomeList;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setNameOfTaxPayer(String nameOfTaxPayer) {
        this.nameOfTaxPayer = nameOfTaxPayer;
    }

    public String getNameOfTaxPayer() {
        return nameOfTaxPayer;
    }

    public void sortTaxListForAmount() {
        taxList.sort(taxComparatorForAmount);
    }

    public void sortTaxListForPeriod() {
        taxList.sort(taxComparatorForPeriod);
    }

    public void sortTaxListForType() {
        taxList.sort(taxComparatorForType);
    }

    public void info()
    {
        System.out.println("nameOfTaxPayer = " + getNameOfTaxPayer());
        incomeList.forEach(income -> System.out.println(income.toString()));
        taxList.forEach(tax -> System.out.println(tax.toString()));
    }
}

