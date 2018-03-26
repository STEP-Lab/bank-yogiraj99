package com.thoughtworks.step.bank;

import java.util.ArrayList;

public class Transactions {
  private final ArrayList<Transaction> list;

  Transactions(){
    list = new ArrayList<Transaction>();
  }

  public void debit(Transaction transaction) {
    list.add(transaction);
  }

  public ArrayList<Transaction> getList() {
    return list;
  }

  public void credit(Transaction transaction) {
    list.add(transaction);
  }
}
