package com.obarra.proventesting.concurrent;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedTest {

    /**
     * This tests a positive race condition. So, it sometime can be pass.
     * @throws Exception
     */
    @Test
    void whenSynchronizedIsNotUsed() throws Exception {
        StupidCounter stupidCounter = new StupidCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(1000);

        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorService.submit(() -> {
                        stupidCounter.addFirstCounter();
                        countDownLatch.countDown();
                    });
                });

        countDownLatch.await();
        assertNotEquals(1000, stupidCounter.getFirstCounter());
    }

    @Test
    void whenLevelInstanceMethodIsUsed() throws Exception {
        StupidCounter stupidCounter = new StupidCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(1000);

        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorService.submit(() -> {
                        stupidCounter.addFirstCounterLevelInstanceMethod();
                        countDownLatch.countDown();
                    });
                });

        countDownLatch.await();
        assertEquals(1000, stupidCounter.getFirstCounter());
    }

    @Test
    void whenRunTwoMethodsOfTheSameInstanceBothAreLevelBlockCode() throws Exception {
        StupidCounter stupidCounter = new StupidCounter();
        ExecutorService executorServiceLevelBlockCode = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatchLevelBlockCode = new CountDownLatch(500);
        IntStream.range(0, 500)
                .forEach(index -> {
                    executorServiceLevelBlockCode.submit(() -> {
                        stupidCounter.addSecondCounterLevelBlockCode();
                        countDownLatchLevelBlockCode.countDown();
                    });
                });

        ExecutorService executorServiceLevelInstanceMethod = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatchLevelInstanceMethod = new CountDownLatch(1000);
        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorServiceLevelInstanceMethod.submit(() -> {
                        stupidCounter.addFirstCounterLevelBlockCode();
                        countDownLatchLevelInstanceMethod.countDown();
                    });
                });

        countDownLatchLevelBlockCode.await();
        assertEquals(500, stupidCounter.getSecondCounter());
        assertNotEquals(1000, stupidCounter.getFirstCounter());
    }

    @Test
    void whenRunTwoMethodsOfTheSameInstanceBothAreLevelInstanceMethod() throws Exception {
        StupidCounter stupidCounter = new StupidCounter();

        ExecutorService executorServiceLevelInstanceMethod = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatchLevelInstanceMethod = new CountDownLatch(500);
        IntStream.range(0, 500)
                .forEach(index -> {
                    executorServiceLevelInstanceMethod.submit(() -> {
                        stupidCounter.addSecondCounterLevelInstanceMethod();
                        countDownLatchLevelInstanceMethod.countDown();
                    });
                });

        ExecutorService executorServiceLevelInstanceMethodOther = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatchLevelInstanceMethodOther = new CountDownLatch(1000);
        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorServiceLevelInstanceMethodOther.submit(() -> {
                        stupidCounter.addFirstCounterLevelInstanceMethod();
                        countDownLatchLevelInstanceMethodOther.countDown();
                    });
                });

        countDownLatchLevelInstanceMethod.await();
        assertEquals(500, stupidCounter.getSecondCounter());
        assertNotEquals(1000, stupidCounter.getFirstCounter());
    }

    @Test
    void whenRunTwoMethodsOfTheSameInstanceOneIsLevelBlockCodeOtherIsLevelInstanceMethod() throws Exception {
        StupidCounter stupidCounter = new StupidCounter();

        ExecutorService executorServiceLevelBlockCode = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatchLevelBlockCode = new CountDownLatch(500);
        IntStream.range(0, 500)
                .forEach(index -> {
                    executorServiceLevelBlockCode.submit(() -> {
                        stupidCounter.addSecondCounterLevelBlockCode();
                        countDownLatchLevelBlockCode.countDown();
                    });
                });

        ExecutorService executorServiceLevelInstanceMethod = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatchLevelInstanceMethod = new CountDownLatch(1000);
        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorServiceLevelInstanceMethod.submit(() -> {
                        stupidCounter.addFirstCounterLevelInstanceMethod();
                        countDownLatchLevelInstanceMethod.countDown();
                    });
                });

        countDownLatchLevelBlockCode.await();
        assertEquals(500, stupidCounter.getSecondCounter());
        assertNotEquals(1000, stupidCounter.getFirstCounter());
    }

    @Test
    void whenRunTwoMethodOfTheDifferentInstanceBothAreLevelInstanceMethod() throws Exception {
        StupidCounter stupidCounter = new StupidCounter();
        ExecutorService executorServiceLevelInstanceMethod = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLevelLatchLevelInstanceMethod = new CountDownLatch(500);
        IntStream.range(0, 500)
                .forEach(index -> {
                    executorServiceLevelInstanceMethod.submit(() -> {
                        stupidCounter.addSecondCounterLevelInstanceMethod();
                        countDownLevelLatchLevelInstanceMethod.countDown();
                    });
                });

        StupidCounter stupidCounterOther = new StupidCounter();
        ExecutorService executorServiceLevelInstanceMethodOther = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatchLevelInstanceMethodOther = new CountDownLatch(1000);
        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorServiceLevelInstanceMethodOther.submit(() -> {
                        stupidCounterOther.addFirstCounterLevelInstanceMethod();
                        countDownLatchLevelInstanceMethodOther.countDown();
                    });
                });

        countDownLevelLatchLevelInstanceMethod.await();
        assertEquals(500, stupidCounter.getSecondCounter());
        assertNotEquals(1000, stupidCounterOther.getFirstCounter());
    }

    @Test
    void whenRunTwoMethodOfTheDifferentInstanceBothAreLevelStaticMethod() throws Exception {
        StupidCounter stupidCounter = new StupidCounter();
        ExecutorService executorServiceLevelStaticMethod = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLevelLatchLevelStaticMethod = new CountDownLatch(500);
        IntStream.range(0, 500)
                .forEach(index -> {
                    executorServiceLevelStaticMethod.submit(() -> {
                        stupidCounter.addFourthStaticCounterLevelStaticMethod();
                        countDownLevelLatchLevelStaticMethod.countDown();
                    });
                });

        StupidCounter stupidCounterOther = new StupidCounter();
        ExecutorService executorServiceLevelStaticMethodOther = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatchLevelStaticMethodOther = new CountDownLatch(1000);
        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorServiceLevelStaticMethodOther.submit(() -> {
                        stupidCounterOther.addThirdStaticCounterLevelStaticMethod();
                        countDownLatchLevelStaticMethodOther.countDown();
                    });
                });

        countDownLevelLatchLevelStaticMethod.await();
        assertEquals(500, stupidCounter.getFourthStaticCounter());
        assertNotEquals(1000, stupidCounterOther.getThirdStaticCounter());
    }

    @Test
    void whenRunTwoMethodOfTheDifferentInstanceOneIsLevelStaticMethodOtherIsLevelInstanceService() throws Exception {
        StupidCounter stupidCounter = new StupidCounter();
        ExecutorService executorServiceLevelStaticMethod = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLevelLatchLevelStaticMethod = new CountDownLatch(1000);
        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorServiceLevelStaticMethod.submit(() -> {
                        stupidCounter.addFourthStaticCounterLevelStaticMethod();
                        countDownLevelLatchLevelStaticMethod.countDown();
                    });
                });

        StupidCounter stupidCounterOther = new StupidCounter();
        ExecutorService executorServiceLevelInstanceMethodOther = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatchLevelInstanceMethodOther = new CountDownLatch(1000);
        IntStream.range(0, 1000)
                .forEach(index -> {
                    executorServiceLevelInstanceMethodOther.submit(() -> {
                        stupidCounterOther.addFirstCounterLevelInstanceMethod();
                        countDownLatchLevelInstanceMethodOther.countDown();
                    });
                });

        countDownLevelLatchLevelStaticMethod.await();
        assertEquals(1000, stupidCounter.getFourthStaticCounter());
        assertNotEquals(1000, stupidCounterOther.getFirstCounter());
    }
}