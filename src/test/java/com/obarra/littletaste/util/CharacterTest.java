package com.obarra.littletaste.util;


import org.junit.Assert;
import org.junit.Test;

public class CharacterTest {
    @Test
    public void isJavaIdentifierStartWhenChIsLeftParenthesis(){
        Assert.assertFalse(Character.isJavaIdentifierStart('('));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsDigit(){
        Assert.assertFalse(Character.isJavaIdentifierStart('9'));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsLowLine(){
        Assert.assertTrue(Character.isJavaIdentifierStart('_'));
    }

    @Test
    public void isJavaIdentifierStartWhenChIsCurrencySymbol(){
        Assert.assertTrue(Character.isJavaIdentifierStart('$'));
    }

    @Test
    public void is(){
        Assert.assertTrue(Character.isJavaIdentifierPart('9'));
    }
}
