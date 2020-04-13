package com.obarra.proventesting.number;


public final class NumberUtil {

    private NumberUtil(){
    }

    /**
     * checking even number  using modulus or remainder operator.
     *
     * @param number
     * @return True if number is even.
     */
    public static Boolean isEven(final Long number) {
        System.out.println(number % 2);
        return (number % 2) == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Boolean isOdd(final Long number) {
        return !isEven(number);
    }

    public static Boolean isEvenStrategyDivisionOperator(final Long number) {
        final Long quotient = number / 2;
        return (quotient * 2) == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Boolean isOddStrategyDivisionOperator(final Long number) {
        return !isEvenStrategyDivisionOperator(number);
    }

    public static Boolean isEvenStrategyBitwiseANDOperator(final Long number) {
        return (number & 1) == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    public static Boolean isOddStrategyBitwiseANDOperator(final Long number) {
        return !isEvenStrategyBitwiseANDOperator(number);
    }
}
