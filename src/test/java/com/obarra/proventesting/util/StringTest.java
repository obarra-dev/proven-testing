package com.obarra.proventesting.util;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void stringLiteralShouldBeTheSameInstance(){
        String username = "obarra";
        String otherUsername = "obarra";
        assertSame(username, otherUsername);
        assertEquals(username, otherUsername);
    }

    @Test
    public void stringLiteralShouldBeNotEqual(){
        String username = "obarra";
        String otherUsername = "obarra";
        assertEquals(username, otherUsername);
    }

    @Test
    public void stringLiteralNewStringShouldBeDifferentInstance(){
        String username = "obarra";
        String otherUsername = new String("obarra");
        assertNotSame(username, otherUsername);
    }

    @Test
    public void stringLiteralNewStringShouldBeEqual(){
        String username = "obarra";
        String otherUsername = new String("obarra");
        assertEquals(username, otherUsername);
    }

    @Test
    public void stringIntern(){
        String username = "obarra";
        String otherUsername = new String("obarra");
        assertEquals(username, otherUsername);
        assertNotSame(username, otherUsername);

        String internStringUsername = otherUsername.intern();
        assertEquals(username, internStringUsername);
        assertSame(username, internStringUsername);
    }

    @Test
    public void constructorWhenArgumentIsArrayOfChars(){
        String expected = "obarra";
        char arrayUsername[]  =  {'o', 'b', 'a', 'r', 'r', 'a'};
        String username = new String(arrayUsername);
        assertEquals(expected, username);
        assertNotSame(expected, username);
    }

    @Test
    public void constructorWhenArgumentIsArrayOfBytes(){
        String expected = "obarra";
        byte[] arrayUsername = { 111, 98, 97, 114, 114, 97};
        String username = new String(arrayUsername);
        assertEquals(expected, username);
        assertNotSame(expected, username);
    }

    @Test
    public void getChars(){
        char[] array = new char[4];
        "omar barra".getChars(0,3, array, 1);

        char[] expected = {Character.MIN_VALUE, 'o', 'm', 'a'};
        assertArrayEquals(expected, array);
    }

    @Test
    public void toCharArray(){
        char[] array = "omar b".toCharArray();

        char[] expected = {'o', 'm', 'a', 'r', ' ', 'b'};
        assertArrayEquals(expected, array);
    }

    @Test
    public void compareToWhenContentsAreTheSameValues(){
        String username = "obarra";
        String otherUsername = "obarra";
        assertEquals(0, otherUsername.compareTo(username));
    }

    /**
     * Compares two strings lexicographically
     * The comparison is based on the Unicode value of each character in the strings.
     */
    @Test
    public void compareToWhenContentsAreDifferent(){
        String username = "obarra";
        String otherUsername = "barrao";
        assertNotEquals(0, otherUsername.compareTo(username));
    }

    @Test
    public void regionMatches(){
        String whole = "Java Programming";
        String part = "Programminggggg";
        assertTrue(whole.regionMatches(5, part, 0, 11));
    }
}
