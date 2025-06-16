package com.building;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrencyDebitCardTests {
    DebitCard debitCard;
    @BeforeEach
    public void before() {
        debitCard = new DebitCard("USD", "Basic debit card");
    }
    @Test
    public void increaseBalance() {
        debitCard.deposit(500.00);
        Assertions.assertEquals(500.00, debitCard.getBalance());
    }

    @Test
    public void reduceBalance() {
        debitCard.deposit(200.00);
        debitCard.reduceAccount(100.00);
        Assertions.assertEquals(100.00, debitCard.getBalance());
    }

    @Test
    public void checkBalance() {
        Assertions.assertEquals(0.00, debitCard.getBalance());
    }
}
