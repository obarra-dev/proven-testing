package com.obarra.littletaste.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

    public static List<Integer> generateByStream(final Integer series){
        return Stream.
                iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(series)
                .map(i -> i[0])
                .collect(Collectors.toList());
    }

    public static List<Integer> generate(final Integer series){
        List<Integer> values = new ArrayList<>();
        values.add(0);
        values.add(1);
        for(int i = 2; i < series; i++){
            values.add(values.get(i-1) + values.get(i -2));
        }
        return values;
    }
}
