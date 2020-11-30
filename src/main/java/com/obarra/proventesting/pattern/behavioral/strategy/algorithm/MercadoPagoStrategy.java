package com.obarra.proventesting.pattern.behavioral.strategy.algorithm;

public class MercadoPagoStrategy implements ChargeStrategy {
    @Override
    public void charge(double amount) {
        System.out.println("to charge with Mercado Pago amount: " + amount);
    }
}
