package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Help implements Command {
    private static String regex = "/[hH]elp *$";

    @Override
    public void doCommand(String command, TaxPayerManager taxPayerManager) {

        Matcher m = Pattern.compile(regex).matcher(command);
        if (m.find()) {
            try(BufferedReader bufferedReader =
                        new BufferedReader(
                                new FileReader("D:\\Projects\\DWJ\\src\\main\\java\\com\\savchuk\\helpInfo\\help.txt"))){
                for (String line; (line = bufferedReader.readLine()) != null;)
                {
                    System.out.println(line);
                }
                TaxPayerManager.getLogger().info("File help.txt read");
            } catch (IOException e) {
                TaxPayerManager.getLogger().error(e.getMessage());
            }
        }
    }
}