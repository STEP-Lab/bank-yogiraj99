package com.thoughtworks.step.bank;

import java.util.ArrayList;
import java.util.Date;

public class Transactions {
  ArrayList<Transaction> list;

  Transactions(){
    list = new ArrayList<Transaction>();
  }

  public void debit(double amount) {
    list.add(new DebitTransaction(amount));
  }

  public ArrayList<Transaction> getList() {
    return list;
  }

  public void credit(double amount) {
    list.add(new CreditTransaction(amount));
  }

  public Transactions filterByAmountGreaterThan(double amountTobeFilterdBy) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction:list) {
      if(transaction.getAmount()>amountTobeFilterdBy){
        filteredTransactions.list.add(transaction);
      }
    }
    return filteredTransactions;
  }

  public Transactions filterByAmountLesserThan(double amountTobeFilterdBy) {
    Transactions filteredTransactions = new Transactions();
    for (Transaction transaction:list) {
      if(transaction.getAmount()<amountTobeFilterdBy){
        filteredTransactions.list.add(transaction);
      }
    }
    return filteredTransactions;
  }

  public Transactions getAllDebitTransactions() {
    Transactions allDebitTransactions = new Transactions();
    for (Transaction transaction:list) {
      if(transaction instanceof DebitTransaction){
        allDebitTransactions.list.add(transaction);
      }
    }
    return allDebitTransactions;
  }

  public Transactions getAllCreditTransactions() {
    Transactions allCreditTransactions = new Transactions();
    for (Transaction transaction:list) {
      if(transaction instanceof CreditTransaction){
        allCreditTransactions.list.add(transaction);
      }
    }
    return allCreditTransactions;
  }

  public Transactions getAllTransactionsBefore(Date date) {
    Transactions allTransactions = new Transactions();
    for (Transaction transaction:list) {
      if(date.compareTo(transaction.getDate())>0){
        allTransactions.list.add(transaction);
      }
    }
    return allTransactions;
  }

  public Transactions getAllTransactionsAfter(Date date) {
    Transactions allTransactions = new Transactions();
    for (Transaction transaction:list) {
      if(date.compareTo(transaction.getDate())<0){
        allTransactions.list.add(transaction);
      }
    }
    return allTransactions;
  }
}
