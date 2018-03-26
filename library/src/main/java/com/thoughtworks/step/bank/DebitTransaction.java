package com.thoughtworks.step.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {
  public DebitTransaction(double amount, String source) {
    super(amount);
  }

  protected DebitTransaction(Date date, int amount) {
    super(date,amount);
  }
}
