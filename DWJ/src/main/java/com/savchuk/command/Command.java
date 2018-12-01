package com.savchuk.command;

import com.savchuk.classes.TaxPayerManager;

public interface Command {
      void doCommand(String command, TaxPayerManager taxPayerManager);
}
