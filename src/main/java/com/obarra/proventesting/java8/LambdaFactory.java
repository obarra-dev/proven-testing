package com.obarra.proventesting.java8;

import com.obarra.proventesting.java8.funtionalinterface.Operator;
import com.obarra.proventesting.java8.funtionalinterface.ArrayInitializer;
import com.obarra.proventesting.java8.funtionalinterface.Constant;

public class LambdaFactory {

    public static Constant getConstantTen(){
        return () -> 10;
    }

    public static Operator getOperatorAdder(){
        return (a, b) -> a + b;
    }

    public static ArrayInitializer getArrayInitializer(){
        return (array, value) -> {
            for(int i = 0; i < array.length; i++){
                array[i] = value;
            }
        };
    }
}
