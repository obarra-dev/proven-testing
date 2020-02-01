package com.obarra.littletaste.pattern.decorator;

import org.junit.Test;

import static org.junit.Assert.*;

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