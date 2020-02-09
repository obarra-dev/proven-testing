package com.obarra.littletaste.util;

import org.junit.Assert;
import org.junit.Test;

public class StringTest {

    @Test
    public void xxxWhenAreTheSameInstance(){
        String username = "obarra";
        String otherUsername = "obarra";
        Assert.assertSame(username, otherUsername);
    }

    @Test
    public void xdxxWhenAreTheSameInstance(){
        String username = "obarra";
        String otherUsername = "obarra";
        Assert.assertEquals(username, otherUsername);
    }

    @Test
    public void xdxxdWhenAreTheSameInstance(){
        String username = "obarra";
        String otherUsername = new String("obarra");
        Assert.assertNotSame(username, otherUsername);
    }

    @Test
    public void constructorWhen(){
        String username = "obarra";
        String otherUsername = new String("obarra");
        Assert.assertEquals(username, otherUsername);
    }

    @Test
    public void constructorWhenArgumentIsArrayOfChars(){
        String expected = "obarra";
        char arrayUsername[]  =  {'o', 'b', 'a', 'r', 'r', 'a'};
        String username = new String(arrayUsername);
        Assert.assertEquals(expected, username);
    }

    @Test
    public void constructorWhenArgumentIsArrayOfBytes(){
        String expected = "obarra";
        byte[] arrayUsername = { 111, 98, 97, 114, 114, 97};
        String username = new String(arrayUsername);
        Assert.assertEquals(expected, username);
    }

    @Test
    public void getChars(){
        char[] array = new char[4];
        "omar barra".getChars(0,3, array, 1);

        char[] expected = {Character.MIN_VALUE, 'o', 'm', 'a'};
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void toCharArray(){
        char[] array = "omar b".toCharArray();

        char[] expected = {'o', 'm', 'a', 'r', ' ', 'b'};
        Assert.assertArrayEquals(expected, array);
    }

    @Test
    public void compareToWhenContentsAreTheSameValues(){
        String username = "obarra";
        String otherUsername = "obarra";
        Assert.assertEquals(0, otherUsername.compareTo(username));
    }

    /**
     * Compares two strings lexicographically
     * The comparison is based on the Unicode value of each character in the strings.
     */
    @Test
    public void compareToWhenContentsAreDifferent(){
        String username = "obarra";
        String otherUsername = "barrao";
        Assert.assertNotEquals(0, otherUsername.compareTo(username));
    }

    @Test
    public void regionMatches(){
        String whole = "Java Programming";
        String part = "Programminggggg";
        Assert.assertTrue(whole.regionMatches(5, part, 0, 11));
    }
}
