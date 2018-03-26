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
    Transaction debitTransaction = new DebitTransaction(1000);
    transactions.debit(debitTransaction);
    assertThat(transactions.getList(),hasItem(new DebitTransaction(1000)));
  }

  @Test
  public void shouldAddCreditTransaction(){
    Transaction creditTransaction = new CreditTransaction(1000);
    transactions.credit(creditTransaction);
    assertThat(transactions.getList(),hasItem(new CreditTransaction(1000)));
  }
}
