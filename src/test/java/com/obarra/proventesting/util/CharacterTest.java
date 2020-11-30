package com.obarra.proventesting.util;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterTest {
    @Test
    public void isJavaIdentifierStartWhenChIsLeftParenthesis() {
        assertFalse(Character.isJavaIdentifierStart('('));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsDigit() {
        assertFalse(Character.isJavaIdentifierStart('9'));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsLowLine() {
        assertTrue(Character.isJavaIdentifierStart('_'));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsCurrencySymbol() {
        assertTrue(Character.isJavaIdentifierStart('$'));
    }
}
