package com.building;

public interface Account {
    String getCurrency();
    double getBalance();
    String getName();
    // пополнение
    void deposit(Double sum);
}
