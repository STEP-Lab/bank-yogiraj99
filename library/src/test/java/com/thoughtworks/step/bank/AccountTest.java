package com.thoughtworks.step.bank;

import com.thoughtworks.step.bank.Account;
import com.thoughtworks.step.bank.Exception.InsufficientBalanceToDebitException;
import com.thoughtworks.step.bank.Exception.NegativeAmountCreditExceotion;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest{
  private Account acc;

  @Before
  public void setUp(){
    acc = new Account("12345",10000.0);
  }

  @Test
  public void shouldGetBalance(){
    assertThat(acc.getBalance(),is(10000.0));
  }

  @Test
  public void shouldHaveAccountNumber(){
    assertThat(acc.getAccountNumber(),is("12345"));
  }

  @Test
  public void shouldCredit() throws NegativeAmountCreditExceotion {
    acc.credit(1000.0);
    assertThat(acc.getBalance(), is(11000.0));
  }

  @Test(expected = NegativeAmountCreditExceotion.class)
  public void shouldNotLetCreditNegativeAmount() throws NegativeAmountCreditExceotion {
    acc.credit(-100.0);
  }

  @Test
  public void shouldDebit() throws InsufficientBalanceToDebitException {
    assertThat(acc.getBalance(), is(10000.0));
    acc.debit(1000.0);
    assertThat(acc.getBalance(), is(9000.0));
  }

  @Test(expected = InsufficientBalanceToDebitException.class)
  public void shouldNotLetDebitWhenDontHaveEnoughBalanceToDebit() throws InsufficientBalanceToDebitException {
    assertThat(acc.getBalance(), is(10000.0));
    acc.debit(acc.getBalance()+1.0);
  }

}