package com.obarra.proventesting.util;

import org.junit.jupiter.api.Test;


import java.text.ParseException;
import java.util.Calendar;
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
        java.sql.Date result = DateUtil.convertDateToSQLDate(date);

        Date expected = convertStringToDate("04/04/1991", "dd/MM/yyyy");

        assertEquals(expected, result);
        System.out.println(result);

    }


}