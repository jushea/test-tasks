package com.building;

public class AbstractAccount implements Account{
    protected String currency;
    protected double balance;
    protected String name;

    public AbstractAccount(String currency, String name) {
        this.currency = currency;
        this.name = name;
        this.balance = 0.0;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void deposit(Double sum) {
        if (sum > 0) {
            balance += sum;
            System.out.println("The account has been replenished ");
        } else {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
    }
}

