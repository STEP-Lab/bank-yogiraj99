package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  private Transactions transactions;
  @Before
  public void setUp(){
    transactions = new Transactions();
  }

  @Test
  public void  shoudldAddDebitTransaction(){
    transactions.debit(1000);
    assertThat(transactions.getList(),hasItem(new DebitTransaction(1000)));
  }

  @Test
  public void shouldAddMoreThanOneDebitTransaction(){
    transactions.debit(1000);
    transactions.debit(1000);
    assertThat(transactions.getList(),hasItems(new DebitTransaction(1000),new DebitTransaction(1000)));
  }

  @Test
  public void shouldAddCreditTransaction(){
    transactions.credit(1000);
    assertThat(transactions.getList(),hasItem(new CreditTransaction(1000)));
  }
  @Test
  @Ignore
  public void shouldPrintTransactions(){

  }
  @Test
  public void shouldFilterTransactionByAmountGreaterThanGivenAmount(){
    transactions.credit(1000);
    transactions.credit(200);
    transactions.credit(4000);
    transactions.debit(2000);
    Transaction creditTransaction = new CreditTransaction(1000);
    Transaction anotherCreditTransaction = new CreditTransaction(4000);
    Transaction debitTransaction = new DebitTransaction(2000);

    Transactions result = transactions.filterByAmountGreaterThan(1000);
    assertThat(result.getList(),hasItems(anotherCreditTransaction,debitTransaction));
  }
  @Test
  public void shouldFilterTransactionByAmountLesserThanGivenAmount(){
    transactions.credit(1000);
    transactions.credit(200);
    transactions.credit(4000);
    transactions.debit(2000);
    transactions.debit(800);
    Transaction creditTransaction = new CreditTransaction(1000);
    Transaction anotherCreditTransaction = new CreditTransaction(200);
    Transaction debitTransaction = new DebitTransaction(800);

    Transactions result = transactions.filterByAmountLesserThan(1100);
    assertThat(result.getList(),hasItems(creditTransaction,anotherCreditTransaction,debitTransaction));
  }
  @Test
  public void shouldGetAllDebitTransactions(){
    transactions.credit(1000);
    transactions.credit(200);
    transactions.credit(4000);
    transactions.debit(2000);
    transactions.debit(800);
    Transaction anotherDebitTransaction = new DebitTransaction(2000);
    Transaction debitTransaction = new DebitTransaction(800);

    Transactions result = transactions.getAllDebitTransactions();
    assertThat(result.getList(),hasItems(anotherDebitTransaction,debitTransaction));
  }
  @Test
  public void shouldGetAllCreditTransactions(){
    transactions.credit(1000);
    transactions.credit(200);
    transactions.credit(4000);
    transactions.debit(2000);
    transactions.debit(800);
    Transaction creditTransaction = new CreditTransaction(1000);
    Transaction anotherCreditTransaction = new CreditTransaction(200);
    Transaction thirdCreditTransaction = new CreditTransaction(4000);

    Transactions result = transactions.getAllCreditTransactions();
    assertThat(result.getList(),hasItems(creditTransaction,anotherCreditTransaction,thirdCreditTransaction));
  }
  @Test
  public void shouldGetAllTransactionsOfBeforeGivenDate(){
    int date = new Date().getDate();
    transactions.credit(1000);
    transactions.credit(4000);
    transactions.debit(800);
    transactions.list.get(0).getDate().setDate(date-3);
    Transaction creditTransaction = new CreditTransaction(1000);
    creditTransaction.getDate().setDate(date-3);
//    Transaction anotherCreditTransaction = new CreditTransaction(200);
//    Transaction debitTransaction = new DebitTransaction(800);
    Transactions result = transactions.getAllTransactionsBefore(new Date());
    assertThat(result.getList(),hasItem(creditTransaction));
  }
  @Test
  public void shouldGetAllTransactionsOfAfterGivenDate(){
    int date = new Date().getDate();
    transactions.credit(1000);
    transactions.credit(4000);
    transactions.debit(800);
    transactions.list.get(0).getDate().setDate(date+2);
    Transaction creditTransaction = new CreditTransaction(1000);
    creditTransaction.getDate().setDate(date+2);
//    Transaction anotherCreditTransaction = new CreditTransaction(200);
//    Transaction debitTransaction = new DebitTransaction(800);
    Date today = new Date();
    Transactions result = transactions.getAllTransactionsAfter(today);
    assertThat(result.getList(),hasItems(creditTransaction));
  }
}
