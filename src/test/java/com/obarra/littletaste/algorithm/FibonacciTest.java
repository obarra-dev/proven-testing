package com.obarra.littletaste.algorithm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FibonacciTest {

    private Integer seed;

    private List<Integer> expected;

    @Before
    public void setUp() {
        seed = 10;
        expected = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
    }

    @Test
    public void generateByStream() {
        Assert.assertEquals(expected, Fibonacci.generate(10));
    }

    @Test
    public void generate() {
        Assert.assertEquals(expected, Fibonacci.generateByStream(10));
    }
}