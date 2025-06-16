package com.building;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditCardTests {
    CreditCard creditCard;
    @BeforeEach
    public void before() {
        creditCard = new CreditCard("RUR", "Basic credit card", 300000.00, 50.00);
    }
    @Test
    public void increaseBalance() {
        creditCard.deposit(500.00);
        Assertions.assertEquals(creditCard.getLimit()+500.00, creditCard.getBalance());

    }

    @Test
    public void reduceBalance() {
        creditCard.reduceAccount(100000.00);
        Assertions.assertEquals(creditCard.getLimit()-100000.00, creditCard.getBalance());
    }

    @Test
    public void checkBalance() {
        Assertions.assertEquals(creditCard.getLimit(), creditCard.getBalance());
    }

    @Test
    public void getDebtCard() {
        creditCard.reduceAccount(250000.00);
        Assertions.assertEquals(creditCard.getLimit() - creditCard.getBalance(), creditCard.getDebt());
    }
}
