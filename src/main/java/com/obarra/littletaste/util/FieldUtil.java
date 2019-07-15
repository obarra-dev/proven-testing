package com.obarra.littletaste.util;


import java.util.Objects;

public class FieldUtil {

    public static boolean compareStrings(final String field, final String otherField){
        String fieldNormalized = getNormalizeString(field);
        String otherFieldNormalized = getNormalizeString(otherField);
        return Objects.equals(fieldNormalized, otherFieldNormalized);
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
