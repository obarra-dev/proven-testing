package com.obarra.littletaste.number;

import java.math.BigDecimal;


public final class BigDecimalUtil {

    private BigDecimalUtil(){

    }

    public static BigDecimal add(final BigDecimal number, final BigDecimal otherNumber){
        return number.add(otherNumber);
    }

    public static BigDecimal rest(final BigDecimal number, final BigDecimal otherNumber){
        return number.subtract(otherNumber);
    }

    public static BigDecimal divide(final BigDecimal dividend, final BigDecimal divisor){
        return dividend.divide(divisor);
    }

    public static BigDecimal multiply(final BigDecimal number, final BigDecimal otherNumber){
        return number.multiply(otherNumber);
    }
}
