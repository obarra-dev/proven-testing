package com.obarra.littletaste.util;


public class FieldUtil {

    public static boolean compareLongs(final Long field, final Long otherField){
        return compare(field, otherField);
    }

    public static boolean compareStrings(final String field, final String otherField){
        String fieldNormalized = getNormalizeString(field);
        String otherFieldNormalized = getNormalizeString(otherField);
        return compare(fieldNormalized, otherFieldNormalized);
    }

    private static boolean compare(final Object object, final Object otherObject){
        if(object == null && otherObject == null){
            return true;
        }
        if(object == null || otherObject == null){
            return false;
        }
        return object.equals(otherObject);
    }

    public static String getNormalizeString(final String field){
        if(field == null){
            return null;
        }

        String stringTrimmed = field.trim();
        if(stringTrimmed.equals("")){
            return null;
        }

        return stringTrimmed.toLowerCase();
    }
}
