package com.savchuk.classes;

import com.savchuk.enums.TaxTypes;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaxPayerManager implements Serializable {
    private static List<TaxPayer> taxPayers = new ArrayList<>();
    private static List<Tax> findList = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(TaxTypes.class);

    public static Logger getLogger() {
        return logger;
    }

    public static List<TaxPayer> getTaxPayers() {
        return taxPayers;
    }

    public static List<Tax> getFindList() {
        return findList;
    }

    public void addTaxPayer(TaxPayer taxPayer) {
        taxPayers.add(taxPayer);
    }

    public boolean deleteTaxPayer(TaxPayer taxPayer) {
        if (taxPayer == null) return false;
        else return taxPayers.remove(taxPayer);
    }

    public TaxPayer findTaxPayer(String nameOfTaxPayer) {
        for (TaxPayer tp : taxPayers) {
            if (tp.getNameOfTaxPayer().equals(nameOfTaxPayer)) return tp;
        }
        return null;
    }

    public void findByAmount(TaxPayer taxPayer, double begin, double end) {
        findList.removeAll(findList);
        for (Tax tax : taxPayer.getTaxList()) {
            if (begin <= tax.getTaxAmount()
                    && end >= tax.getTaxAmount()) {
                findList.add(tax);
            }
        }
    }

    public void findByRate(TaxPayer taxPayer, double begin, double end) {
        findList.removeAll(findList);
        for (Tax tax : taxPayer.getTaxList()) {
            if (begin <= tax.getTaxRate()
                    && end >= tax.getTaxRate()) {
                findList.add(tax);
            }
        }
    }

    public void findByPeriod(TaxPayer taxPayer, Period begin, Period end) {
        findList.removeAll(findList);
        for (Tax tax : taxPayer.getTaxList()) {
            if (begin.getTimeInMonth() <= tax.getTaxPeriod().getTimeInMonth()
                    && end.getTimeInMonth() >= tax.getTaxPeriod().getTimeInMonth()) {
                findList.add(tax);
            }
        }
    }

    public void findByType(TaxPayer taxPayer, TaxTypes type) {
        findList.removeAll(findList);
        for (Tax tax : taxPayer.getTaxList()) {
            if (type == tax.getType()) {
                findList.add(tax);
            }
        }
    }

    public void printTaxPayersList() {
        int number = 1;
        for (TaxPayer taxPayer : taxPayers) {
            System.out.println(number++ + ") " + "TaxPayer{" + taxPayer.getNameOfTaxPayer() + "}");
        }
    }

    public void writePayersListInFile() {
        try {
            ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(
                    "D:\\Projects\\DWJ\\src\\main\\java\\com\\savchuk\\savedTaxPayers\\"
                            + "{" + this.toString() + "}" + Integer.toHexString(this.hashCode()) + ".dat"));
            objectWriter.flush();
            objectWriter.writeObject(getTaxPayers());
            objectWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writePayerInFile(TaxPayer taxPayer) {
        try {
            ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(
                    "D:\\Projects\\DWJ\\src\\main\\java\\com\\savchuk\\savedTaxPayers\\"
                            + "{" + taxPayer.getNameOfTaxPayer() + "}" + Integer.toHexString(taxPayer.hashCode()) + ".dat"));
            objectWriter.flush();
            objectWriter.writeObject(taxPayer);
            objectWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readPayerFromFile(String name) {
        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(
                    "D:\\Projects\\DWJ\\src\\main\\java\\com\\savchuk\\savedTaxPayers\\" + name + ".dat"));
            taxPayers.add((TaxPayer) objectReader.readObject());
            objectReader.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readPayersListFromFile(String name) {

        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(
                    "D:\\Projects\\DWJ\\src\\main\\java\\com\\savchuk\\savedTaxPayers\\" + name + ".dat"));
            taxPayers.addAll((ArrayList<TaxPayer>) objectReader.readObject());
            objectReader.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "TaxPayersList";
    }
}
