package com.obarra.proventesting.java8;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.function.LongBinaryOperator;

public class LongBinaryOperatorTest {

    @Test
    public void applyAsLong(){
        LongBinaryOperator getMinor = (x, y) -> x > y?y:x;
        assertEquals(-2, getMinor.applyAsLong(-2, 3));
        assertEquals(5, getMinor.applyAsLong(10, 5));
    }
}
