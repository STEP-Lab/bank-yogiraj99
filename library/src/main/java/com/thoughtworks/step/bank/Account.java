package com.thoughtworks.step.bank;

public class Account {
  private final String accountNumber;
  private int balance;

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

  public boolean doesHaveMinimumBalance() {
    if (balance>=1000){
      return true;
    }
    return false;
  }

  public double credit(int creditAmount) {
    return balance+=creditAmount;
  }
}
