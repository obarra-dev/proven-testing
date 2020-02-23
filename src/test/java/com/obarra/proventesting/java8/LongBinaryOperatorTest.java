package com.obarra.proventesting.java8;

import com.obarra.proventesting.Person;
import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;

public class LongBinaryOperatorTest {

    @Test
    public void applyAsLong(){
        LongBinaryOperator getMinor = (x, y) -> x > y?y:x;
        assertEquals(-2, getMinor.applyAsLong(-2, 3));
        assertEquals(5, getMinor.applyAsLong(10, 5));
    }
}
