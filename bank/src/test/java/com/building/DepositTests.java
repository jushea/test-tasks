package com.building;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepositTests {
    Deposit deposit;
    @BeforeEach
    public void before() {
        deposit = new Deposit("RUR", "Deposit");
    }
    @Test
    public void increaseBalance() {
        deposit.deposit(500.00);
        Assertions.assertEquals(500.00, deposit.getBalance());
    }

    @Test
    public void closeNotEmptyAccount() {
        deposit.deposit(500.00);
        deposit.closeAccount();
        Assertions.assertEquals(500.00, deposit.getBalance());
    }

    @Test
    public void closeEmptyAccount() {
        deposit.closeAccount();
        Assertions.assertEquals(0.00, deposit.getBalance());
    }

}
