import com.thoughtworks.step.bank.Account;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest{
  @Test
  public void checkBalance(){
    Account acc = new Account("12345",10000);
    assertThat(acc.getBalance(),is(10000));
  }
  @Test
  public void checkAccountNumber(){
    Account acc = new Account("12345",10000);
    assertThat(acc.getAccountNumber(),is("12345"));
  }
}