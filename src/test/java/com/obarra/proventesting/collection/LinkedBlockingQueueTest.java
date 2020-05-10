package com.obarra.proventesting.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class LinkedBlockingQueueTest {

    @Test
    void addWhenQueueWhitExplicitCapacityShouldBeHasBound() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(2);
        blockingQueue.addAll(Arrays.asList(9, 2));
        Assertions.assertThrows(IllegalStateException.class, ()-> blockingQueue.add(1));
    }

    @Test
    void addWhenQueueWithDefaultCapacityShouldBeNotBound() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        Assertions.assertEquals(Integer.MAX_VALUE, blockingQueue.remainingCapacity());

        //this test is only representative
        IntStream.range(0, 500)
                .forEach(index -> blockingQueue.add(index));
        Assertions.assertDoesNotThrow(() ->blockingQueue.add(1));
    }

    @Test
    void add() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.add(9);
        blockingQueue.add(2);

        Assertions.assertEquals(2, blockingQueue.size());
    }

    @Test
    void poll() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.addAll(Arrays.asList(9, 2, 3));

        Assertions.assertEquals(9, blockingQueue.poll());
        Assertions.assertEquals(2, blockingQueue.poll());
        Assertions.assertEquals(3, blockingQueue.poll());
        Assertions.assertNull(blockingQueue.poll());
    }

    @Test
    void offer() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(2);
        Assertions.assertTrue(blockingQueue.offer(2));
        Assertions.assertTrue(blockingQueue.offer(3));
        Assertions.assertFalse(blockingQueue.offer(1));
    }

    @Test
    void peek() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.add(9);
        blockingQueue.add(2);

        Assertions.assertEquals(9, blockingQueue.peek());
        Assertions.assertEquals(9, blockingQueue.peek());
    }

    @Test
    void putWaitingForSpaceToBecomesAvailable() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(2);
        blockingQueue.put(9);
        blockingQueue.put(2);

        Assertions.assertEquals(2, blockingQueue.size());
    }

    @Test
    void takeWaitingUntilAnElementBecomesAvailable() throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.put(9);
        blockingQueue.put(2);
        blockingQueue.put(3);

        Assertions.assertEquals(9, blockingQueue.take());
        Assertions.assertEquals(2, blockingQueue.take());
        Assertions.assertEquals(3, blockingQueue.take());
    }

}
