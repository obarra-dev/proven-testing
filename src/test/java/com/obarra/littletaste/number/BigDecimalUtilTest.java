package com.obarra.littletaste.number;


import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BigDecimalUtilTest {

    @Test
    public void add() {
        BigDecimal number = new BigDecimal("0.3");
        BigDecimal otherNumber = new BigDecimal("0.7");
        BigDecimal result = BigDecimalUtil.add(number, otherNumber);
        BigDecimal expectedResult = new BigDecimal("1.0");
        assertEquals(expectedResult, result);
    }

    @Test
    public void addOther() {
        BigDecimal number = new BigDecimal("0.3");
        BigDecimal otherNumber = new BigDecimal("0.7");
        BigDecimal result = BigDecimalUtil.add(number, otherNumber);
        BigDecimal expectedResult = new BigDecimal("1.00");
        assertNotEquals(expectedResult, result);
    }


    @Test
    public void rest() {
        BigDecimal number = new BigDecimal("1000.0");
        BigDecimal otherNumber = new BigDecimal("0.001");
        BigDecimal result = BigDecimalUtil.rest(number, otherNumber);
        BigDecimal expectedResult = new BigDecimal("999.999");
        assertEquals(expectedResult, result);
    }

    @Test(expected = ArithmeticException.class)
    public void divide() {
        BigDecimal dividend = new BigDecimal("1");
        BigDecimal divisor = new BigDecimal("3");
        BigDecimal result = BigDecimalUtil.divide(dividend, divisor);
        BigDecimal expectedResult = new BigDecimal("999.999");
        assertEquals(expectedResult, result);
    }

    @Test
    public void multiply() {
    }
}