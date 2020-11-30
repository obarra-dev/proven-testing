package com.obarra.proventesting.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class ParameterizedTest {

    private BigDecimal value;
    private BigDecimal otherValue;
    private BigDecimal expected;

    public ParameterizedTest(BigDecimal value, BigDecimal otherValue, BigDecimal expected) {
        this.value = value;
        this.otherValue = otherValue;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][]{{new BigDecimal("0.3"),
                new BigDecimal("0.7"),
                new BigDecimal("1.0")}, {
                new BigDecimal("1000.0"),
                new BigDecimal("0.001"),
                new BigDecimal("1000.001")
        }});
    }

    @Test
    public void bigDecimalAdd() {
        BigDecimal result = value.add(otherValue);
        assertEquals(expected, result);
    }
}
