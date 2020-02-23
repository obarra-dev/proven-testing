package com.obarra.proventesting.java8;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

public class IntUnaryOperatorTest {

    @Test
    public void applyAsInt(){
        IntUnaryOperator squareRoot = (x) -> x*x;
        assertEquals(0, squareRoot.applyAsInt(0));
        assertEquals(1, squareRoot.applyAsInt(1));
        assertEquals(4, squareRoot.applyAsInt(2));
        assertEquals(9, squareRoot.applyAsInt(3));
    }
}
