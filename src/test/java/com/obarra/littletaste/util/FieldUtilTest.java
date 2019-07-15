package com.obarra.littletaste.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldUtilTest {
    private long fieldLong = 899L;
    private long otherFieldLong = 99L;
    private String fieldString = " ELENaMArieLA    ";
    private String otherFieldString = "        ";
    


    @Test
    public void compareLongsWhenAreNulls() {
        assertTrue(FieldUtil.compareLongs(null, null));
    }

    @Test
    public void compareLongsWhenOtherIsNumberAndOtherIsNUll() {
        assertFalse(FieldUtil.compareLongs(fieldLong, null));
    }

    @Test
    public void compareLongsWhenOtherIsNullAndOtherIsNumber() {
        assertFalse(FieldUtil.compareLongs(null, fieldLong));
    }

    @Test
    public void compareLongsWhenAreNumbersEquals() {
        Long sameField = new Long(fieldLong);
        assertTrue(FieldUtil.compareLongs(fieldLong, sameField));
    }

    @Test
    public void compareLongsWhenAreNumbersDifferent() {
        assertFalse(FieldUtil.compareLongs(fieldLong, otherFieldLong));
    }

    @Test
    public void compareStringsWhenAreNulls() {
        assertTrue(FieldUtil.compareStrings(null, null));
    }

    @Test
    public void compareStringsWhenOtherIsNumberAndOtherIsNUll() {
        assertFalse(FieldUtil.compareStrings(fieldString, null));
    }

    @Test
    public void compareStringsWhenOtherIsNullAndOtherIsNumber() {
        assertFalse(FieldUtil.compareStrings(null, fieldString));
    }

    @Test
    public void compareStringsWhenAreNumbersEquals() {
        String sameString = new String(fieldString);
        assertTrue(FieldUtil.compareStrings(fieldString, sameString));
    }

    @Test
    public void compareStringsWhenAreNumbersDifferent() {
        assertFalse(FieldUtil.compareStrings(fieldString, otherFieldString));
    }

    @Test
    public void getNormalizeStringWhenThereIsString() {
        String normalized = FieldUtil.getNormalizeString(fieldString);
        assertEquals("elenamariela", normalized);
    }

    @Test
    public void getNormalizeStringWhenThereIsNotString() {
        String normalized = FieldUtil.getNormalizeString("     ");
        assertNull(normalized);
    }
}