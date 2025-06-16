package com.building;

public class DebitCard extends AbstractAccount{
    public DebitCard(String currency, String name) {
        super(currency, name);
    }

    public void reduceAccount(Double sum) {
        if (sum > 0 && sum <= getBalance()) {
            balance -= sum;
        } else {
            throw new IllegalArgumentException("Недостаточно средств или неверная сумма");
        }
    }
}
