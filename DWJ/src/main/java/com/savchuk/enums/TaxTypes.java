package com.savchuk.enums;

import java.io.Serializable;
import java.util.*;

import static com.savchuk.enums.IncomeTypes.*;

public enum TaxTypes implements Serializable {
    INCOME(SALARY, SCHOLARSHIP, DIVIDENTS, INTEREST, PENSION),
    PROPERTY(RENTOFPROPERTY, SALEOFPROPERTY),
    SALEOFGOODS(SALEOFPROPERTY),
    OPERATIONS(GIFTS, SALEOFPROPERTY),
    ACTIVITIES(ADDITIONALACTIVITY, ECONOMICACTIVITY),
    EXPENSES(RENTOFPROPERTY);

    public Set<IncomeTypes> relationTaxIncome = new TreeSet<>();

    TaxTypes(IncomeTypes... incomeType) {
        relationTaxIncome.addAll(Arrays.asList(incomeType));
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static boolean checkType(String type) {
        for (TaxTypes taxTypes : values()) {
            if (taxTypes.toString().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
}
