package com.obarra.proventesting.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberUtilTest {

    @Test
    void isEven() {
        assertTrue(NumberUtil.isEven(0L));
    }

    @Test
    void isOdd() {
        assertFalse(NumberUtil.isOdd(0L));
    }

    @Test
    void isEvenWhenUseMaxLong() {
        assertFalse(NumberUtil.isEven(Long.MAX_VALUE));
    }

    @Test
    void isEvenStrategyBitwiseANDOperator() {
        assertTrue(NumberUtil.isEvenStrategyBitwiseANDOperator(0L));
    }

    @Test
    void isOddStrategyBitwiseANDOperator() {
        assertFalse(NumberUtil.isOddStrategyBitwiseANDOperator(0L));
    }

    @Test
    void isEvenStrategyBitwiseANDOperatorWhenUseMaxLong() {
        assertFalse(NumberUtil.isEvenStrategyBitwiseANDOperator(Long.MAX_VALUE));
    }


    @Test
    void isEvenStrategyDivisionOperator() {
        assertTrue(NumberUtil.isEvenStrategyDivisionOperator(0L));
    }

    @Test
    void isOddStrategyDivisionOperator() {
        assertFalse(NumberUtil.isOddStrategyDivisionOperator(0L));
    }

    @Test
    void isEvenStrategyDivisionOperatorWhenUseMaxLong() {
        assertFalse(NumberUtil.isEvenStrategyDivisionOperator(Long.MAX_VALUE));
    }

}