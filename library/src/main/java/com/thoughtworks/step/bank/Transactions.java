package com.thoughtworks.step.bank;

import java.util.ArrayList;

public class Transactions {
  private final ArrayList<Transaction> transactions;

  Transactions(){
    transactions = new ArrayList<Transaction>();
  }

  public void debit(DebitTransaction transaction) {
    transactions.add(transaction);
  }

  public ArrayList<Transaction> getTransactions() {
    return transactions;
  }
}
