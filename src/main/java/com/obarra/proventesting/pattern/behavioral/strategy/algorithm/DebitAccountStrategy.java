package com.obarra.proventesting.pattern.behavioral.strategy.algorithm;

public class DebitAccountStrategy implements ChargeStrategy{
    @Override
    public void charge(double amount) {
        System.out.println("to charge with Debit account: "+amount);
    }
}
