package com.thoughtworks.step.bank.Exception;

public class NegativeAmountCreditExceotion extends Throwable {
  public NegativeAmountCreditExceotion(double amountToBeCredited) {
    super("Can not credit :"+amountToBeCredited);
  }
}
