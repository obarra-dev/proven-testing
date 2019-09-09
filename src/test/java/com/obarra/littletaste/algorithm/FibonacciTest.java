package com.obarra.littletaste.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void generateByStream() {
        System.out.println(Fibonacci.generate(10));
    }

    @Test
    public void generate() {
        System.out.println(Fibonacci.generateByStream(10));
    }
}