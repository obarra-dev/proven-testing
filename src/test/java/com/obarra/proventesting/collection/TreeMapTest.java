package com.obarra.proventesting.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TreeMapTest {

    private TreeMap<String, String> treeMap;

    @BeforeEach
    void setUp() {
        treeMap = new TreeMap<>();
        treeMap.put("python", ".py");
        treeMap.put("kotlin", ".kt");
        treeMap.put("golang", ".go");
    }

    /**
     * Comparable of String is for natural order.
     */
    @Test
    void addWhenUseComparableNaturalOfString() {
        Iterator<Map.Entry<String, String>> iterator = treeMap.entrySet().iterator();

        Map.Entry<String, String> entry = iterator.next();
        assertEquals("golang", entry.getKey());
        assertEquals(".go", entry.getValue());

        entry = iterator.next();
        assertEquals("kotlin", entry.getKey());
        assertEquals(".kt", entry.getValue());

        entry = iterator.next();
        assertEquals("python", entry.getKey());
        assertEquals(".py", entry.getValue());
    }

    @Test
    void addWhenUseComparatorAlternativeSortForString() {
        Map<String, String> result = new TreeMap<>((x, y) -> -x.compareTo(y));
        result.put("python", ".py");
        result.put("kotlin", ".kt");
        result.put("golang", ".go");

        Iterator<Map.Entry<String, String>> iterator = result.entrySet().iterator();

        Map.Entry<String, String> entry = iterator.next();
        assertEquals("python", entry.getKey());
        assertEquals(".py", entry.getValue());

        entry = iterator.next();
        assertEquals("kotlin", entry.getKey());
        assertEquals(".kt", entry.getValue());

        entry = iterator.next();
        assertEquals("golang", entry.getKey());
        assertEquals(".go", entry.getValue());
    }

    @Test
    void testMapWithAssertJ() {
        assertThat(treeMap)
                .isNotEmpty()
                .hasSize(3)
                .containsKeys("golang", "kotlin")
                .doesNotContainKeys("java", "js")
                .containsValues(".go", ".kt")
                .doesNotContainValue(".java")
                .doesNotContainEntry("der", "value")
                .containsEntry("golang", ".go");
    }

    @Test
    void firstEntry() {
        Map.Entry<String, String> result = treeMap.firstEntry();
        assertEquals("golang", result.getKey());
        assertEquals(".go", result.getValue());
    }

    @Test
    void lowerEntry() {
        Map.Entry<String, String> result = treeMap.lowerEntry("kotlin");
        assertEquals("golang", result.getKey());
        assertEquals(".go", result.getValue());
    }

    @Test
    void lastEntry() {
        Map.Entry<String, String> result = treeMap.lastEntry();
        assertEquals("python", result.getKey());
        assertEquals(".py", result.getValue());
    }

    @Test
    void higherEntry() {
        Map.Entry<String, String> result = treeMap.higherEntry("kotlin");
        assertEquals("python", result.getKey());
        assertEquals(".py", result.getValue());
    }

    @Test
    void removeShouldBeRemoveTheEntryAndReturnTheValue() {
        assertEquals(".kt", treeMap.remove("kotlin"));
    }

    @Test
    void removeForGivenKeyIfItIsMappedGivenValue() {
        assertFalse(treeMap.remove("kotlin", "der"));
    }

    @Test
    void pollFirstEntry() {
        Map.Entry<String, String> result = treeMap.pollFirstEntry();
        assertEquals("golang", result.getKey());
        assertEquals(".go", result.getValue());
    }

    @Test
    void pollLastEntry() {
        Map.Entry<String, String> result = treeMap.pollLastEntry();
        assertEquals("python", result.getKey());
        assertEquals(".py", result.getValue());
    }
}
