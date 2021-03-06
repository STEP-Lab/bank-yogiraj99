package com.thoughtworks.step.bank;

import java.util.Date;
import java.util.Objects;

abstract public class Transaction {
  private final Date date;
  private final double amount;

  public Transaction(double amount){
    this.amount = amount;
    this.date=new Date();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return Double.compare(that.amount, amount) == 0 && Objects.equals(date.toString(), that.date.toString());
  }

  @Override
  public int hashCode() {

    return Objects.hash(date, amount);
  }

  public double getAmount() {
    return amount;
  }

  public Date getDate() {
    return date;
  }
}
