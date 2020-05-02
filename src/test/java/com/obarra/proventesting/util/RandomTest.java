package com.obarra.proventesting.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTest {

    /**
     *
     * Instances of {@code java.util.Random} are threadsafe.
     * However, the concurrent use of the same {@code java.util.Random}
     * instance across threads may encounter contention and consequent
     * poor performance.
     */
    @Test
    void randomNextInt() {
        Random random = new Random();
        Assertions.assertNotEquals(2, random.nextInt(2));
        Assertions.assertNotEquals(2, random.nextInt(2));
    }

    /**
     * Consider instead using
     * {@link java.util.concurrent.ThreadLocalRandom} in multithreaded
     * designs.
     *
     */
    @Test
    void threadLocalRandom() {
        Assertions.assertNotEquals(2, ThreadLocalRandom.current().nextInt(0, 2));
        Assertions.assertNotEquals(2, ThreadLocalRandom.current().nextInt(0, 2));
    }

    /**
     * Math.random() uses Random.nextDouble() internally.
     */
    @Test
    void mathRandom() {
        double randomValue = Math.random();
        Double randomDoubleValue = Double.valueOf(randomValue);
        Assertions.assertNotNull(randomDoubleValue);
        Assertions.assertEquals(Double.class, randomDoubleValue.getClass());
    }

}
