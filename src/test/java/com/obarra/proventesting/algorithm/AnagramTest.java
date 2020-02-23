package com.obarra.proventesting.algorithm;

import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    @Test
    public void areAnagramsMethodCountAndCompareWhenAreDifferentForOneLetter() {
        assertFalse(Anagram.areAnagramsMethodCountAndCompare("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenAreOKAnagrams() {
        assertTrue(Anagram.areAnagramsMethodCountAndCompare("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenTheWordsHasTwoLetters() {
        assertTrue(Anagram.areAnagramsMethodCountAndCompare("go", "og"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenTheWordHasSpace() {
        assertTrue(Anagram.areAnagramsMethodCountAndCompare("BAC D", "ABCD "));
    }


    @Test
    public void areAnagramsMethodSortAndCompareWhenAreDifferentForOneLetter() {
        assertFalse(Anagram.areAnagramsMethodSortAndCompare("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenAreOKAnagrams() {
        assertTrue(Anagram.areAnagramsMethodSortAndCompare("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenTheWordsHasTwoLetters() {
        assertTrue(Anagram.areAnagramsMethodSortAndCompare("go", "og"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenTheWordHasSpace() {
        assertTrue(Anagram.areAnagramsMethodSortAndCompare("BAC D", "ABCD "));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenAreDifferentForOneLetter() {
        assertFalse(Anagram.areAnagramsMethodCheckingOff("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenAreOKAnagrams() {
        assertTrue(Anagram.areAnagramsMethodCheckingOff("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenTheWordsHasTwoLetters() {
        assertTrue(Anagram.areAnagramsMethodCheckingOff("go", "og"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenTheWordHasSpace() {
        assertTrue(Anagram.areAnagramsMethodCheckingOff("BAC D", "ABCD "));
    }

    @Test
    public void areAnagramsMethodBitManipulationWhenAreDifferentForOneLetter() {
        assertFalse(Anagram.areAnagramsMethodBitManipulation("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodBitManipulationWhenAreOKAnagrams() {
        assertTrue(Anagram.areAnagramsMethodBitManipulation("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodBitManipulationWhenTheWordsHasTwoLetters() {
        assertTrue(Anagram.areAnagramsMethodBitManipulation("go", "og"));
    }

    @Test
    public void areAnagramsMethodBitManipulationWhenTheWordHasSpace() {
        assertTrue(Anagram.areAnagramsMethodBitManipulation("BAC D", "ABCD "));
    }
}