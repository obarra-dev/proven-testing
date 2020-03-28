package com.obarra.proventesting.java8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureTest {

    @Nested
    class ConstructorTest {
        @Test
        public void completeTest() throws ExecutionException, InterruptedException {
            CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Complete");
            Assertions.assertEquals("Complete", completableFuture.get());
        }

        @Test
        public void runAsyncTest() throws ExecutionException, InterruptedException {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(CompletableFutureTest::runner);
            Assertions.assertNull(completableFuture.get());
        }

        @Test
        public void supplyAsyncTest() throws ExecutionException, InterruptedException {
            CompletableFuture<String> completableFuture = CompletableFuture
                    .supplyAsync(CompletableFutureTest::supply);
            Assertions.assertEquals("Supply", completableFuture.get());
        }

        //exist constructor for consumer and apply?

    }

    @Nested
    class CallBack {
        /**
         * This combination doesn't make sense
         * @throws ExecutionException
         * @throws InterruptedException
         */
        @Test
        public void thenRunAsyncToCompleteFutureTest() throws ExecutionException, InterruptedException {
            CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Complete");
            CompletableFuture<Void> future = completableFuture.thenRunAsync(CompletableFutureTest::runner);
            Assertions.assertNull(future.get());
        }

        @Test
        public void thenApplyAsyncToCompleteFutureTest() throws ExecutionException, InterruptedException {
            CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Complete");
            CompletableFuture<String> future = completableFuture.thenApplyAsync(CompletableFutureTest::apply);
            Assertions.assertEquals("Apply: Complete", future.get());
        }

        @Test
        public void thenAcceptAsyncToCompleteFutureTest() throws ExecutionException, InterruptedException {
            CompletableFuture<String> completableFuture = CompletableFuture.completedFuture("Complete");
            CompletableFuture<Void> future = completableFuture.thenAccept(CompletableFutureTest::consumer);
            Assertions.assertNull(future.get());
        }

        @Test
        public void thenRunAsyncTest() throws ExecutionException, InterruptedException {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(CompletableFutureTest::runner);
            CompletableFuture<Void> future = completableFuture.thenRunAsync(CompletableFutureTest::runner);
            Assertions.assertNull(future.get());
        }

        /**
         * This combination doesn't make sense, in this combination the callback doesn't accept reference method
         * @throws ExecutionException
         * @throws InterruptedException
         */
        @Test
        public void thenApplyAsyncToRunAsync() throws ExecutionException, InterruptedException {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(CompletableFutureTest::runner);
            CompletableFuture<String> future = completableFuture.thenApplyAsync(result ->  "Apply: "+ result);
            Assertions.assertEquals("Apply: null", future.get());
        }

        /**
         * This combination doesn't make sense, in this combination the callback doesn't accept reference method
         * @throws ExecutionException
         * @throws InterruptedException
         */
        @Test
        public void thenAcceptAsyncToRunAsync() throws ExecutionException, InterruptedException {
            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(CompletableFutureTest::runner);
            CompletableFuture<Void> future = completableFuture.thenAcceptAsync(result -> {
                System.out.println("Consumer:" + result);
            });
            Assertions.assertNull( future.get());
        }

        /**
         * In Java 8 don't exist a supply callback, but in java 9, it was added as completeAsync
         * @throws ExecutionException
         * @throws InterruptedException
         */
        @Test
        public void thenApplyAsyncToSupplyAsyncTest() throws ExecutionException, InterruptedException {
            CompletableFuture<String> completableFuture = CompletableFuture
                    .supplyAsync(CompletableFutureTest::supply);

            CompletableFuture<String> future = completableFuture.thenApplyAsync(CompletableFutureTest::apply);
            Assertions.assertEquals("Apply: Supply", future.get());
        }

        @Test
        public void thenAcceptAsyncToSupplyAsyncTest() throws ExecutionException, InterruptedException {
            CompletableFuture<String> completableFuture = CompletableFuture
                    .supplyAsync(CompletableFutureTest::supply);

            CompletableFuture<Void> future = completableFuture.thenAcceptAsync(CompletableFutureTest::consumer);
            Assertions.assertNull(future.get());
        }

        /**
         * This combination doesn't make sense
         * @throws ExecutionException
         * @throws InterruptedException
         */
        @Test
        public void thenRunAsyncToSupplyAsyncTest() throws ExecutionException, InterruptedException {
            CompletableFuture<String> completableFuture = CompletableFuture
                    .supplyAsync(CompletableFutureTest::supply);

            CompletableFuture<Void> future = completableFuture.thenRunAsync(CompletableFutureTest::runner);
            Assertions.assertNull(future.get());
        }



        @Nested
        class Exception {

            @Test
            void exceptionallyAsyncTest() throws ExecutionException, InterruptedException {
                CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException("Error in the future");
                });

                //debe retornar un valor del mismo tipo que el futuro en el que se originó la excepción.
                CompletableFuture<String> futureException = completableFuture
                        .exceptionallyAsync(e -> "Handler: " + e.getMessage());

                Assertions.assertEquals("Handler: java.lang.RuntimeException: Error in the future",
                        futureException.get());
            }


            /**
             * Manages result or exception
             */
            @Test
            void handleAsyncTest() throws ExecutionException, InterruptedException {
                CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException("Error in the future");
                });

                //debe retornar un valor del mismo tipo que el futuro en el que se originó la excepción.
                CompletableFuture<String> futureException = completableFuture
                        .handleAsync((r, e) -> {
                            if(e != null){
                                return "Handler: "+ e.getMessage();
                            }else{
                                return "String ok" + r;
                            }
                        });

                Assertions.assertEquals("Handler: java.lang.RuntimeException: Error in the future",
                        futureException.get());
            }

            @Test
            public void whenCompleteAsyncTest() throws ExecutionException, InterruptedException {
                //dif entre when y then; dif entre when y handel
                CompletableFuture<String> completableFuture = CompletableFuture
                        .supplyAsync(CompletableFutureTest::supply);
                CompletableFuture<String> future = completableFuture
                        .whenCompleteAsync((r, e) -> System.out.println(r + " Task was finished, exception: "+e));

                Assertions.assertEquals("Supply", future.get());
            }
        }
    }

    // se ejecuta en un hilo diferente, creo q todos
    @Test
    public void invokeAPITest() throws ExecutionException, InterruptedException {
        Supplier<String> supplier = () -> {
            return "value of api";
        };

        // invoke api
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);

        CompletableFuture<String> future = completableFuture.thenApplyAsync(CompletableFutureTest::apply);
        Assertions.assertEquals("Apply: value of api", future.get());
    }

    @Test
    public void invokeAPIWithPhasesOkErrorAlwaysWhenIsSuccessfulTest() throws ExecutionException, InterruptedException {
        Supplier<String> supplier = () -> {
            return "value of api";
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
        completableFuture.thenApplyAsync(CompletableFutureTest::apply)
                .exceptionally(e -> e.getMessage())
                .thenAccept(f -> System.out.println(f +" Accept"));
    }

    @Test
    public void invokeAPIWithPhasesOkErrorAlwaysWhenIsErrorTest() throws ExecutionException, InterruptedException {
        Supplier<String> supplier = () -> {
             throw new RuntimeException("Error in the future");
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
        completableFuture.thenApplyAsync(CompletableFutureTest::apply)
                .exceptionally(e -> e.getMessage())
                .thenAccept(f -> System.out.println(f +" Accept"));
    }

    public static void runner() {
        System.out.println("Runner");
    }
    public static String supply() {
        return "Supply";
    }
    public static void consumer(final String value) {
        System.out.println("Consumer: " + value);
    }
    public static String apply(final String value) {
        return "Apply: " + value;
    }
}
