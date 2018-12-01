package com.savchuk.enums;

import java.io.Serializable;

public enum IncomeTypes implements Serializable {
    SALARY,
    SCHOLARSHIP,
    RENTOFPROPERTY,
    ADDITIONALACTIVITY,
    ECONOMICACTIVITY,
    GIFTS,
    INTEREST,
    DIVIDENTS,
    SALEOFPROPERTY,
    PENSION;

    @Override
    public String toString() {
        return super.toString();
    }

    public static boolean checkType(String type) {
        for (IncomeTypes incomeTypes : values()) {
            if (incomeTypes.toString().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
}
