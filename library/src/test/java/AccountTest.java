import com.thoughtworks.step.bank.Account;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest{
  @Test
  public void checkBalance(){
    Account acc = new Account("12345",10000);
    assertThat(acc.getBalance(),is(10000.0));
  }
  @Test
  public void checkAccountNumber(){
    Account acc = new Account("12345",10000);
    assertThat(acc.getAccountNumber(),is("12345"));
  }
  @Test
  public void checkMinimumBalance(){
    Account acc = new Account("12345",100);
    assertThat(acc.doesHaveMinimumBalance(),is(false));
    Account acc2 = new Account("12345",10000);
    assertThat(acc2.doesHaveMinimumBalance(),is(true));
  }
  @Test
  public void checkCredit() {
    Account acc = new Account("12345", 10000);
    acc.credit(1000);
    assertThat(acc.getBalance(), is(11000.0));
  }
}