package com.obarra.littletaste.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.IntUnaryOperator;

public class IntUnaryOperatorTest {

    @Test
    public void applyAsInt(){
        IntUnaryOperator squareRoot = (x) -> x*x;
        Assert.assertEquals(0, squareRoot.applyAsInt(0));
        Assert.assertEquals(1, squareRoot.applyAsInt(1));
        Assert.assertEquals(4, squareRoot.applyAsInt(2));
        Assert.assertEquals(9, squareRoot.applyAsInt(3));
    }
}
