package com.thoughtworks.step.bank;

import com.thoughtworks.step.bank.Exception.InsufficientBalanceToDebitException;
import com.thoughtworks.step.bank.Exception.NegativeAmountCreditExceotion;

public class Account {
  private final String accountNumber;
  private double balance;

  public Account(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public double credit(double amountToBeCredited) throws NegativeAmountCreditExceotion {
    if (canCredit(amountToBeCredited)){
      return balance+=amountToBeCredited;
    }
    throw new NegativeAmountCreditExceotion(amountToBeCredited);
  }

  private boolean canCredit(double amountToBeCredited) {
    return amountToBeCredited>0;
  }

  public double debit(double amountToBeDebited) throws InsufficientBalanceToDebitException {
    if (canDebit(amountToBeDebited)){
      return balance= balance - amountToBeDebited;
    }
    throw new InsufficientBalanceToDebitException();
  }

  private boolean canDebit(double amountToBeDebited) {
    return balance>=amountToBeDebited;
  }
}
