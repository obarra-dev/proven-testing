package com.obarra.littletaste.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void getDateWithoutTime() {
        Date dateWithoutTime = DateUtil.getDateWithoutTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateWithoutTime);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        long MILLISECONDS_PER_DAY = 86400000L;
        calendar.setTimeInMillis(dateWithoutTime.getTime() + MILLISECONDS_PER_DAY - 1);
        assertEquals(day, calendar.get(Calendar.DAY_OF_MONTH));

        calendar.setTimeInMillis(dateWithoutTime.getTime() + MILLISECONDS_PER_DAY);
        assertNotEquals(day, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testGetDateWithoutTime() {
        Date dateWithoutTime = DateUtil.getDateWithoutTime(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateWithoutTime);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        long MILLISECONDS_PER_DAY = 86400000L;
        calendar.setTimeInMillis(dateWithoutTime.getTime() + MILLISECONDS_PER_DAY - 1);
        assertEquals(day, calendar.get(Calendar.DAY_OF_MONTH));

        calendar.setTimeInMillis(dateWithoutTime.getTime() + MILLISECONDS_PER_DAY);
        assertNotEquals(day, calendar.get(Calendar.DAY_OF_MONTH));
    }
}