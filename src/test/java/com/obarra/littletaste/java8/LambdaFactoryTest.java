package com.obarra.littletaste.java8;

import com.obarra.littletaste.java8.funtionalinterface.ArrayInitializer;
import com.obarra.littletaste.java8.funtionalinterface.Constant;
import com.obarra.littletaste.java8.funtionalinterface.Operator;
import org.junit.Test;

import static org.junit.Assert.*;

public class LambdaFactoryTest {

    @Test
    public void getConstantTen() {
        Constant constant = LambdaFactory.getConstantTen();
        assertEquals(10, constant.value());
    }

    @Test
    public void getOperatorAdder() {
        Operator operator = LambdaFactory.getOperatorAdder();
        assertEquals(10, operator.operate(7, 3));
    }

    @Test
    public void getArrayInitializer() {
        ArrayInitializer arrayInitializer = LambdaFactory.getArrayInitializer();
        String[] array = new String[4];
        arrayInitializer.initialize(array, "M");
        assertArrayEquals(new String[]{"M", "M", "M", "M"}, array);
    }
}