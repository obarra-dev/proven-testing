package com.obarra.proventesting.pattern.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoDecoratorTest {

    @Test
    public void calculateQuotationOfAXA() {
        assertEquals(275, DemoDecorator.calculateQuotationOfAXA(5), 0.001);
    }

    @Test
    public void calculateMathReserveOfVillanueva() {
        assertEquals(4750, DemoDecorator.calculateMathReserveOfVillanueva(5), 0.001);
    }


    @Test
    public void calculateQuotationOfVillanueva() {
        assertEquals(475, DemoDecorator.calculateQuotationOfVillanueva(5), 0.001);
    }

    @Test
    public void calculateMathReserveOfAXA() {
        assertEquals(2750, DemoDecorator.calculateMathReserveOfAXA(5), 0.001);
    }

}