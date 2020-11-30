package com.obarra.proventesting.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ConcurrentHashMapTest {

    @Test
    void concurrentHashMap() throws InterruptedException {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        performConcurrency(map);
        Assertions.assertTrue(map.size() > 0);
    }

    @Test
    void concurrentHashMapWhenKeyIsNull() throws InterruptedException {
        Map<Integer, String> map = new ConcurrentHashMap<>();

        Assertions.assertThrows(NullPointerException.class, () -> {
            map.put(null, "value");
        });
    }

    @Test
    void concurrentHashMapWhenValueIsNull() throws InterruptedException {
        Map<Integer, String> map = new ConcurrentHashMap<>();

        Assertions.assertThrows(NullPointerException.class, () -> {
            map.put(1, null);
        });
    }

    @Test
    public void removeWhenIterateShouldNotThrowsExceptions() {
        Map<Integer, String> map1 = new ConcurrentHashMap<>();
        map1.put(1, "employee1");
        map1.put(2, "employee2");
        map1.put(3, "employee3");

        Iterator<Integer> iterator = map1.keySet().iterator();

        Assertions.assertDoesNotThrow(() -> {
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                map1.remove(2);
            }
        });
    }

    @Test
    void hashTable() throws InterruptedException {
        Map<Integer, String> map = new Hashtable<>();
        performConcurrency(map);
        Assertions.assertTrue(map.size() > 0);
    }

    @Test
    void synchronizedMap() throws InterruptedException {
        Map<Integer, String> map = Collections.synchronizedMap(new Hashtable<>());
        performConcurrency(map);
        Assertions.assertTrue(map.size() > 0);
    }

    private void performConcurrency(final Map<Integer, String> map) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Instant start = Instant.now();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                IntStream.range(0, 5000)
                        .forEach(index -> {
                            Integer key = ThreadLocalRandom.current().nextInt(0, 10);
                            map.get(key);
                            map.put(key, key.toString());
                        });
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis() + " Milliseconds");
    }
}
