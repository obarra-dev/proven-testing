package com.obarra.proventesting.concurrent;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {

    private static ExecutorService executorService;

    @BeforeAll
    public static void beforeAll() {
        executorService = Executors.newFixedThreadPool(3);
    }

    @AfterAll
    public static void afterAll() {
        executorService.shutdown();
    }

    /**
     * Callable is similar a Supply
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void futureWithCallableAndOK() throws ExecutionException, InterruptedException {
        Future<String> future = executorService.submit(() -> "Supply");
        Assertions.assertEquals("Supply", future.get());
    }

    @Test
    public void futureWithCallableAndException() {
        Future<String> future = executorService.submit(() -> {
            throw new RuntimeException("Future with error");
        });
        Assertions.assertThrows(ExecutionException.class, () -> {
            future.get();
        });
    }
}
