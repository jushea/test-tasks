package com.building;

public class CreditCard extends AbstractAccount{
    private Double rate;
    private Double limit;

    public CreditCard(String currency, String name, Double limit, Double rate) {
        super(currency, name);
        this.balance = limit;
        this.rate = rate;
        this.limit = limit;
    }

    public void reduceAccount(Double sum) {
        if (sum > 0 && sum <= getBalance()) {
            balance -= sum;
        } else {
            throw new IllegalArgumentException("Недостаточно средств или неверная сумма");
        }
    }

    public Double getDebt() {
        Double result = this.limit - this.balance;
        System.out.println("Card is " + this.name + " Debt " + result);
        return result;
    }

    public Double getLimit() {
        return limit;
    }

    public Double getRate() {
        return rate;
    }
}
