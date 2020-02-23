package com.obarra.proventesting.util;


import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    @Test
    public void isJavaIdentifierStartWhenChIsLeftParenthesis(){
        assertFalse(Character.isJavaIdentifierStart('('));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsDigit(){
        assertFalse(Character.isJavaIdentifierStart('9'));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsLowLine(){
        assertTrue(Character.isJavaIdentifierStart('_'));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsCurrencySymbol(){
        assertTrue(Character.isJavaIdentifierStart('$'));
    }
}
