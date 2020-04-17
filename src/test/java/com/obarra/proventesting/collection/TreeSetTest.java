package com.obarra.proventesting.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class TreeSetTest {

    private TreeSet<String> expectedNaturalOrder;

    @BeforeEach
    void setUp() {
        expectedNaturalOrder = new TreeSet<>();
        expectedNaturalOrder.add("Barra");
        expectedNaturalOrder.add("Maru");
        expectedNaturalOrder.add("Omar");
    }

    /**
     * Comparable of String is for natural order.
     */
    @Test
    void addWhenUseComparableNaturalOfString() {
        Set<String> result = new TreeSet<>();
        result.add("Omar");
        result.add("Barra");
        result.add("Maru");

        assertIterableEquals(expectedNaturalOrder, result);
    }

    @Test
    void addWhenUseComparatorAlternativeSortForString() {
        Set<String> result = new TreeSet<>((x, y) -> -x.compareTo(y));
        result.add("Omar");
        result.add("Barra");
        result.add("Maru");

        Iterator<String> iterator = result.iterator();
        assertEquals("Omar", iterator.next());
        assertEquals("Maru", iterator.next());
        assertEquals("Barra", iterator.next());
    }

}
