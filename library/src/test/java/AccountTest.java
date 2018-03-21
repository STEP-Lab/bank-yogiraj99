import com.thoughtworks.step.bank.Account;
import com.thoughtworks.step.bank.Exception.InsufficientBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest{
  private Account acc;

  @Before
  public void setUp(){
    acc = new Account("12345",10000);
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
  public void shouldCredit() {
    acc.credit(1000);
    assertThat(acc.getBalance(), is(11000.0));
  }

  @Test
  public void shouldDebit() throws InsufficientBalanceException {
    assertThat(acc.getBalance(), is(10000.0));
    acc.debit(1000);
    assertThat(acc.getBalance(), is(9000.0));
  }

  @Test(expected = InsufficientBalanceException.class)
  public void shouldNotLetDebitWhenDontHAveEnoughBalanceToDebit() throws InsufficientBalanceException {
    assertThat(acc.getBalance(), is(10000.0));
    acc.debit(acc.getBalance()+1);
  }
}