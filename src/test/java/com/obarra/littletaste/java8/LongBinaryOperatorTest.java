package com.obarra.littletaste.java8;

import com.obarra.littletaste.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.LongBinaryOperator;
import java.util.function.Predicate;

public class LongBinaryOperatorTest {

    @Test
    public void applyAsLong(){
        LongBinaryOperator getMinor = (x, y) -> x > y?y:x;
        Assert.assertEquals(-2, getMinor.applyAsLong(-2, 3));
        Assert.assertEquals(5, getMinor.applyAsLong(10, 5));
    }
}
