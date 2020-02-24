package com.obarra.proventesting.junit5;


import org.junit.jupiter.api.*;

/**
 * Junit5 creates a new class instance for every test run, for every method
 * @BeforeAll and @AfterAll must be static
 * This is the default TestInstance, @TestInstance(TestInstance.Lifecycle.PER_METHOD)
 */
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestInstancePerMethodTest {

    Integer variable = 1;

    @BeforeAll
    static void beforeAll(){
        System.out.println("BeforeAll is executed before of instance de test so it can not access to variables");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("AfterAll is executed after of instance de test so it can not access to variables");
    }

    @Test
    void testOne(){
        Assertions.assertEquals(1, variable);
        variable++;
        Assertions.assertEquals(2, variable);
    }

    @Test
    void testTwo(){
        Assertions.assertEquals(1, variable);
        variable = null;
        Assertions.assertNull(variable);
    }

    @Test
    void testThree(){
        Assertions.assertNotNull(variable);
    }
}
