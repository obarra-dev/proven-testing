package com.obarra.proventesting.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListTest {

    @Test
    public void addByIndex() {
        List<Long> longLinkedList = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (long i = 0; i < 100000L; i++) {
            longLinkedList.add(i);
            if (i > 5) longLinkedList.add(5, i);
        }
        long end = System.currentTimeMillis();
        long timeOfLinkedList = end - start;
        System.out.println(timeOfLinkedList + " LINKEDLIST");

        List<Long> longArrayList = new ArrayList<>();
        start = System.currentTimeMillis();
        for (long i = 0; i < 100000L; i++) {
            longArrayList.add(i);
            if (i > 5) longArrayList.add(5, i);
        }

        end = System.currentTimeMillis();
        long timeOfArrayList = end - start;
        System.out.println(timeOfArrayList + " ARRAYLIST");
        assertTrue(timeOfArrayList > timeOfLinkedList);
    }

    @Test
    public void add() {
        List<Long> longLinkedList = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (long i = 0; i < 5000000L; i++) {
            longLinkedList.add(i);
        }
        long end = System.currentTimeMillis();
        long timeOfLinkedList = end - start;
        System.out.println(timeOfLinkedList + " LINKEDLIST");

        List<Long> longArrayList = new ArrayList<>();
        start = System.currentTimeMillis();
        for (long i = 0; i < 5000000L; i++) {
            longArrayList.add(i);
        }

        end = System.currentTimeMillis();
        long timeOfArrayList = end - start;
        System.out.println(timeOfArrayList + " ARRAYLIST");
        assertTrue(timeOfArrayList < timeOfLinkedList);
    }

    @Test
    public void iterate() {
        List<Long> longLinkedList = new LinkedList<>();
        for (long i = 0; i < 5000000L; i++) {
            longLinkedList.add(i);
        }
        long start = System.currentTimeMillis();
        for (Long number : longLinkedList) ;
        long end = System.currentTimeMillis();
        long timeOfLinkedList = end - start;
        System.out.println(timeOfLinkedList + " LINKEDLIST");

        List<Long> longArrayList = new ArrayList<>();
        for (long i = 0; i < 5000000L; i++) {
            longArrayList.add(i);
        }
        start = System.currentTimeMillis();
        for (Long number : longArrayList) ;
        end = System.currentTimeMillis();
        long timeOfArrayList = end - start;
        System.out.println(timeOfArrayList + " ARRAYLIST");
        assertTrue(timeOfArrayList < timeOfLinkedList);
    }

    @Test
    public void order() {
        List<Long> longLinkedList = new LinkedList<>();
        for (long i = 0; i < 5000000L; i++) {
            longLinkedList.add(i);
        }
        long start = System.currentTimeMillis();
        Collections.sort(longLinkedList);
        long end = System.currentTimeMillis();
        long timeOfLinkedList = end - start;
        System.out.println(timeOfLinkedList + " LINKEDLIST");

        List<Long> longArrayList = new ArrayList<>();
        for (long i = 0; i < 5000000L; i++) {
            longArrayList.add(i);
        }
        start = System.currentTimeMillis();
        Collections.sort(longArrayList);
        end = System.currentTimeMillis();
        long timeOfArrayList = end - start;
        System.out.println(timeOfArrayList + " ARRAYLIST");
        assertTrue(timeOfArrayList < timeOfLinkedList);
    }


    @Test
    public void get() {
        List<Long> longLinkedList = new LinkedList<>();
        for (long i = 0; i < 5000000L; i++) {
            longLinkedList.add(i);
        }
        long start = System.currentTimeMillis();
        Long aLong = longLinkedList.get(100000);
        long end = System.currentTimeMillis();
        long timeOfLinkedList = end - start;
        System.out.println(timeOfLinkedList + " LINKEDLIST" + aLong);

        List<Long> longArrayList = new ArrayList<>();
        for (long i = 0; i < 5000000L; i++) {
            longArrayList.add(i);
        }
        start = System.currentTimeMillis();
        aLong = longArrayList.get(100000);
        end = System.currentTimeMillis();
        long timeOfArrayList = end - start;
        System.out.println(timeOfArrayList + " ARRAYLIST" + aLong);
        assertTrue(timeOfArrayList < timeOfLinkedList);
    }
}