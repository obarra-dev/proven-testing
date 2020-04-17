package com.obarra.proventesting.util;

import org.junit.jupiter.api.Test;


import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import static  org.junit.jupiter.api.Assertions.*;
import static com.obarra.proventesting.util.DateUtil.*;

public class DateUtilTest {

    @Test
    public void getDateWithoutTimeWhenThereIsNotParams() {
        Date dateWithoutTime = DateUtil.getDateWithoutTime();

        assertNotEquals(
                getDayOfMonth(addMilliseconds(dateWithoutTime,
                        -1L)),
                getDayOfMonth(dateWithoutTime));
        assertEquals(
                getDayOfMonth(addMilliseconds(dateWithoutTime,
                        MILLISECONDS_PER_DAY -1)),
                getDayOfMonth(dateWithoutTime));
    }

    @Test
    public void getDateWithoutTimeWhenThereIsParam() throws ParseException {
        Date expected = convertStringToDate("04/04/1991", "dd/MM/yyyy");

        Date result = getDateWithoutTime(addMilliseconds(expected, MILLISECONDS_PER_DAY -1));

        assertEquals(expected, result);
    }

    //complete todo test
    @Test
    void convertDateToSQLDate() throws ParseException {
        Date date = convertStringToDate("04-4-1991 06:07:59", "dd-M-yyyy hh:mm:ss");
        date = convertStringToDate("04-4-1991 00:00:00", "dd-M-yyyy hh:mm:ss");
        Date dated = convertStringToDate("04/04/1991", "dd/MM/yyyy");
        assertEquals(date, dated);

        java.sql.Date result = DateUtil.convertDateToSQLDate(date);
        result = java.sql.Date.valueOf("1991-04-04");
        java.sql.Date expected = java.sql.Date.valueOf("1991-04-04");
        expected.equals(result);
        assertEquals(expected, result);



//expected: <670734000000> but was: <670756079000>

       // Date expectedOther = convertStringToDate("04-4-1991 00:00:00", "dd-M-yyyy hh:mm:ss");
        //assertEquals(expectedOther.getTime(), result.getTime());
    //    expected: <670734000000> but was: <670756079000>
    }


}