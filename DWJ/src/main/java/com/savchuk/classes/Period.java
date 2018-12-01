package com.savchuk.classes;

import java.io.Serializable;

public class Period implements Serializable {
    private int timeInYear;
    private double timeInMonth;

    public void setTimeInMonth(int timeInMonth) {
        this.timeInMonth = timeInMonth;
    }

    public void setTimeInYear(int timeInYear) {
        this.timeInYear = timeInYear;
    }

    public double getTimeInYear() {
        return timeInYear + (timeInMonth / 12.0);
    }

    public double getTimeInMonth() {
        if (timeInMonth != 0) return timeInMonth;
        else return timeInYear * 12;
    }

    public Period(double time) {
        this.timeInYear = (int) time;
        this.timeInMonth = (int) (12 * (time - (int) time));
    }

    @Override
    public String toString() {
        return "Period{" +
                "timeInYear=" + timeInYear +
                ", timeInMonth=" + timeInMonth +
                '}';
    }
}
