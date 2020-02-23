package com.obarra.proventesting.collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Comparator {

    @Test
    public void comparingWhitStringLengthAscendant(){
        List<String> names = Arrays.asList("Omar", "Mariela", "Elena", "Helen", "Mar");
        Collections.sort(names, java.util.Comparator.comparing(String::length));

        List<String> expectedName = Arrays.asList("Mar", "Omar", "Elena", "Helen", "Mariela");
        assertIterableEquals(expectedName, names);
    }

    @Test
    public void comparingWhitStringLengthDecrease(){
        List<String> names = Arrays.asList("Omar", "Mariela", "Elena", "Helen", "Mar");
        Collections.sort(names, (a , b) -> b.length() - a.length());

        List<String> expectedName = Arrays.asList("Mariela", "Elena", "Helen", "Omar", "Mar");
        assertIterableEquals(expectedName, names);
    }

    @Test
    public void comparingWhitStringHashCode(){
        List<String> names = Arrays.asList("Omar", "Mariela", "Elena", "Helen", "Mar");
        Collections.sort(names, java.util.Comparator.comparing(String::hashCode));

        List<String> expectedName = Arrays.asList("Mariela", "Mar", "Omar", "Elena", "Helen");
        assertIterableEquals(expectedName, names);
    }
}
