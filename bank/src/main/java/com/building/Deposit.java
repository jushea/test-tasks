package com.building;

public class Deposit extends AbstractAccount{
    public Deposit(String currency, String name) {
        super(currency, name);
    }

    public void closeAccount() {
        if (getBalance() > 0) {
            System.out.println("it is impossible to close the account. Account is open.");
        } else {
            balance = 0.0;
            currency = null;
            name = "UNDEFINED";
        }
    }
}
