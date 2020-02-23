package com.obarra.littletaste.collection;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Comparator {

    @Test
    public void comparingWhitStringLengthAscendant(){
        List<String> names = Arrays.asList("Omar", "Mariela", "Elena", "Helen", "Mar");
        Collections.sort(names, java.util.Comparator.comparing(String::length));

        List<String> expectedName = Arrays.asList("Mar", "Omar", "Elena", "Helen", "Mariela");
        MatcherAssert.assertThat(expectedName, CoreMatchers.is(names));
    }

    @Test
    public void comparingWhitStringLengthDecrease(){
        List<String> names = Arrays.asList("Omar", "Mariela", "Elena", "Helen", "Mar");
        Collections.sort(names, (a , b) -> b.length() - a.length());

        List<String> expectedName = Arrays.asList("Mariela", "Elena", "Helen", "Omar", "Mar");
        MatcherAssert.assertThat(expectedName, CoreMatchers.is(names));
    }

    @Test
    public void comparingWhitStringHashCode(){
        List<String> names = Arrays.asList("Omar", "Mariela", "Elena", "Helen", "Mar");
        Collections.sort(names, java.util.Comparator.comparing(String::hashCode));

        List<String> expectedName = Arrays.asList("Mariela", "Mar", "Omar", "Elena", "Helen");
        MatcherAssert.assertThat(expectedName, CoreMatchers.is(names));
    }
}
