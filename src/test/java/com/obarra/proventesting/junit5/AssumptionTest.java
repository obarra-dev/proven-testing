package com.obarra.proventesting.junit5;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssumptionTest {

    @Test
    @DisplayName("Test runs if server is up, in this case is't up")
    void testIfServerIsUpWhenIsNotUp() {
        Boolean isServerUp = Boolean.FALSE;
        Assumptions.assumeTrue(isServerUp);
        System.out.println("Server is up");
    }

    @Test
    @DisplayName("Test runs if server is up, in this case is up")
    void testIfServerIsUpWhenIsUp() {
        Boolean isServerUp = Boolean.TRUE;
        Assumptions.assumeTrue(isServerUp);
        System.out.println("Server is up");
    }
}
