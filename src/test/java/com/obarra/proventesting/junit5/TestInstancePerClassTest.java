package com.obarra.proventesting.junit5;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * Per class create only instance
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInstancePerClassTest {

    Integer variable = 1;

    @BeforeAll
    void beforeAll() {
        System.out.println(variable);
    }

    @AfterAll
    void afterAll() {
        System.out.println(variable);
    }

    @Test
    void testOne() {
        Assertions.assertEquals(1, variable);
        variable++;
        Assertions.assertEquals(2, variable);
    }

    @Test
    void testTwo() {
        Assertions.assertEquals(2, variable);
    }
}
