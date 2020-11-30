package com.obarra.proventesting.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SupplierTest {
    private static final String MESSAGE = "Say something only if test fails";

    @Test
    void withoutSupplierShouldBeShowMessageAlways() {
        Assertions.assertTrue(true, showMessage());
    }

    @Test
    void withSupplierShouldBeShowMessageOnlyOnFails() {
        Assertions.assertTrue(true, () -> showMessage());
    }

    private String showMessage() {
        System.out.println(MESSAGE);
        return MESSAGE;
    }
}
