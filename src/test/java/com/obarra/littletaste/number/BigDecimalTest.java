package com.obarra.littletaste.number;


import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BigDecimalTest {

    @Test
    public void add() {
        BigDecimal number = new BigDecimal("0.3");
        BigDecimal otherNumber = new BigDecimal("0.7");
        BigDecimal result = number.add(otherNumber);
        BigDecimal expectedResult = new BigDecimal("1.0");
        assertEquals(expectedResult, result);
    }

    @Test
    public void addOther() {
        BigDecimal number = new BigDecimal("0.3");
        BigDecimal otherNumber = new BigDecimal("0.7");
        BigDecimal result = number.add(otherNumber);
        BigDecimal expectedResult = new BigDecimal("1.00");
        assertNotEquals(expectedResult, result);
    }


    @Test
    public void rest() {
        BigDecimal number = new BigDecimal("1000.0");
        BigDecimal otherNumber = new BigDecimal("0.001");
        BigDecimal result = number.subtract(otherNumber);
        BigDecimal expectedResult = new BigDecimal("999.999");
        assertEquals(expectedResult, result);
    }

    @Test(expected = ArithmeticException.class)
    public void divide() {
        BigDecimal dividend = new BigDecimal("1");
        BigDecimal divisor = new BigDecimal("3");
        BigDecimal result = dividend.divide(divisor);
        BigDecimal expectedResult = new BigDecimal("999.999");
        assertEquals(expectedResult, result);
    }

    @Test
    public void multiply() {
        BigDecimal number = new BigDecimal("10.00");
        BigDecimal tax = new BigDecimal("0.0825");
        BigDecimal result = number.multiply(tax);
        BigDecimal expectedResult = new BigDecimal("0.825000");
        assertEquals(expectedResult, result);
    }

    @Test
    public void dder(){
        BigDecimal number = new BigDecimal(0.33);
        //330000000000000015543122344752191565930843353271484375
        assertNotEquals( "0.33", number.toString());
    }

    @Test
    public void ddser(){
        BigDecimal number = new BigDecimal("0.33");
        assertEquals("0.33", number.toString());
    }

    @Test
    public void roundingCeiling(){
        BigDecimal number = new BigDecimal("0.333");
        BigDecimal result = number.setScale(2, BigDecimal.ROUND_CEILING);
        assertEquals("0.33", result);
    }
}