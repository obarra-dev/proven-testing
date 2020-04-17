package com.obarra.proventesting.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * This represents a complete day in milliseconds.
     */
    public static final Long MILLISECONDS_PER_DAY = 86400000L;

    /**
     * This method returns a full current date with the time set to zero,
     * but we can't ignore the time. Use Calendar
     */
    public static Date getDateWithoutTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getDateWithoutTime(final Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static java.sql.Date convertDateToSQLDate(final Date date){
        return new java.sql.Date(date.getTime());
    }

    public static Integer getDayOfMonth(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date addMilliseconds(final Date date, final Long milliseconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime() + milliseconds);
        return calendar.getTime();
    }

    public static Date convertStringToDate(final String dateString, final String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(dateString);
    }
}
