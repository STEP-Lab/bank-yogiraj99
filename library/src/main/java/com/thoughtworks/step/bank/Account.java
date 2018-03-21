package com.thoughtworks.step.bank;

import com.thoughtworks.step.bank.Exception.InsufficientBalanceException;

public class Account {
  private final String accountNumber;
  private double balance;

  public Account(String accountNumber, int balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public double credit(int creditAmount) {
    return balance+=creditAmount;
  }

  public double debit(double amountToBeDebited) throws InsufficientBalanceException {
    if (canDebit(amountToBeDebited)){
      return balance= balance - amountToBeDebited;
    }
    throw new InsufficientBalanceException();
  }

  private boolean canDebit(double amountToBeDebited) {
    return balance>=amountToBeDebited;
  }
}
