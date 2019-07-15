package com.obarra.littletaste.util;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class FieldUtilTest {
    private long fieldLong = 899L;
    private long otherFieldLong = 99L;
    private String fieldString = " ELENaMArieLA    ";
    private String otherFieldString = "        ";
    


    @Test
    public void compareLongsWhenAreNulls() {
        assertTrue(Objects.equals(null, null));
    }

    @Test
    public void compareLongsWhenOtherIsNumberAndOtherIsNUll() {
        assertFalse(Objects.equals(fieldLong, null));
    }

    @Test
    public void compareLongsWhenOtherIsNullAndOtherIsNumber() {
        assertFalse(Objects.equals(null, fieldLong));
    }

    @Test
    public void compareLongsWhenAreNumbersEquals() {
        Long sameField = new Long(fieldLong);
        assertTrue(Objects.equals(fieldLong, sameField));
    }

    @Test
    public void compareLongsWhenAreNumbersDifferent() {
        assertFalse(Objects.equals(fieldLong, otherFieldLong));
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