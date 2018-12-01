package com.savchuk.classes;

import com.savchuk.enums.IncomeTypes;

import java.io.Serializable;

public class Income implements Serializable {
    private double totalValue;
    private Period periodOfReceipt;
    private IncomeTypes type;

    public Income(double totalValue, Period periodOfReceipt, IncomeTypes type) {
        this.totalValue = totalValue;
        this.periodOfReceipt = periodOfReceipt;
        this.type = type;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public void setPeriodOfReceipt(Period periodOfReceipt) {
        this.periodOfReceipt = periodOfReceipt;
    }

    public void setType(IncomeTypes type) {
        this.type = type;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public Period getPeriodOfReceipt() {
        return periodOfReceipt;
    }

    public IncomeTypes getType() {
        return type;
    }

    public double calculateIncomeForPeriod(Period periodOfTime) {
        return (int)(periodOfTime.getTimeInMonth() / periodOfReceipt.getTimeInMonth()) * totalValue;
    }

    public Income combineIncomes(Income another) {
        if (this.type == another.getType()) {
            if (this.periodOfReceipt.getTimeInMonth() == another.getPeriodOfReceipt().getTimeInMonth()) {
                return new Income(this.totalValue + another.getTotalValue(), this.periodOfReceipt, this.type);
            } else if (this.periodOfReceipt.getTimeInMonth() > another.getPeriodOfReceipt().getTimeInMonth()) {
                return new Income(this.totalValue + another.getTotalValue(), this.periodOfReceipt, this.type);
            } else if (this.periodOfReceipt.getTimeInMonth() < another.getPeriodOfReceipt().getTimeInMonth()) {
                return new Income(this.totalValue + another.getTotalValue(), another.getPeriodOfReceipt(), this.type);
            }
        }
        return this;
    }

    @Override
    public String toString() {
        return "Income{" +
                "totalValue=" + totalValue +
                ", periodOfReceipt=" + periodOfReceipt +
                ", type=" + type +
                '}';
    }
}
