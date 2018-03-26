package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  private Transactions transactions;
  @Before
  public void setUp(){
    transactions = new Transactions();
  }

  @Test
  public void  shoudldAddDebitTransaction(){
    DebitTransaction debitTransaction = new DebitTransaction(new Date(),1000);
    transactions.debit(debitTransaction);
    assertThat(transactions.getTransactions(),hasItem(new DebitTransaction(new Date(),1000)));
  }

}
