package com.obarra.littletaste.pattern.behavioral.strategy;

import com.obarra.littletaste.pattern.behavioral.strategy.algorithm.DebitAccountStrategy;
import com.obarra.littletaste.pattern.behavioral.strategy.algorithm.MercadoPagoStrategy;

public class DemoStrategy {
    public static void main(String[] args) {
        ChargeContext chargeContext = new ChargeContext(new MercadoPagoStrategy());
        chargeContext.charge(404);

        chargeContext = new ChargeContext(new DebitAccountStrategy());
        chargeContext.charge(501);

    }
}
