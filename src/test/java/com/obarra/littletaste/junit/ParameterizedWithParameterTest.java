package com.obarra.littletaste.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(value = Parameterized.class)
public class ParameterizedWithParameterTest {

    @Parameterized.Parameter
    public BigDecimal value;

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        return Arrays.asList( new Object[][]{
                {new BigDecimal("0.3")},{
                new BigDecimal("1000.001")
        }});
    }

    @Test
    public void bigDecimalNotNull() {
        assertNotNull(value);
    }
}
