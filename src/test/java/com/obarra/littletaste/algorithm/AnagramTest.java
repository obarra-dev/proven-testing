package com.obarra.littletaste.algorithm;

import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

public class AnagramTest {

    @Test
    public void areAnagramsMethodCountAndCompareWhenAreDifferentForOneLetter() {
        assertEquals(false, Anagram.areAnagramsMethodCountAndCompare("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenAreOKAnagrams() {
        assertEquals(true, Anagram.areAnagramsMethodCountAndCompare("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenTheWordsHasTwoLetters() {
        assertEquals(true, Anagram.areAnagramsMethodCountAndCompare("go", "og"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenTheWordHasSpace() {
        assertEquals(true, Anagram.areAnagramsMethodCountAndCompare("BAC D", "ABCD "));
    }


    @Test
    public void areAnagramsMethodSortAndCompareWhenAreDifferentForOneLetter() {
        assertEquals(false, Anagram.areAnagramsMethodSortAndCompare("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenAreOKAnagrams() {
        assertEquals(true, Anagram.areAnagramsMethodSortAndCompare("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenTheWordsHasTwoLetters() {
        assertEquals(true, Anagram.areAnagramsMethodSortAndCompare("go", "og"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenTheWordHasSpace() {
        assertEquals(true, Anagram.areAnagramsMethodSortAndCompare("BAC D", "ABCD "));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenAreDifferentForOneLetter() {
        assertEquals(false, Anagram.areAnagramsMethodCheckingOff("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenAreOKAnagrams() {
        assertEquals(true, Anagram.areAnagramsMethodCheckingOff("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenTheWordsHasTwoLetters() {
        assertEquals(true, Anagram.areAnagramsMethodCheckingOff("go", "og"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenTheWordHasSpace() {
        assertEquals(true, Anagram.areAnagramsMethodCheckingOff("BAC D", "ABCD "));
    }

    @Test
    public void areAnagramsMethodBitManipulationWhenAreDifferentForOneLetter() {
        assertEquals(false, Anagram.areAnagramsMethodBitManipulation("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodBitManipulationWhenAreOKAnagrams() {
        assertEquals(true, Anagram.areAnagramsMethodBitManipulation("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodBitManipulationWhenTheWordsHasTwoLetters() {
        assertEquals(true, Anagram.areAnagramsMethodBitManipulation("go", "og"));
    }

    @Test
    public void areAnagramsMethodBitManipulationWhenTheWordHasSpace() {
        assertEquals(true, Anagram.areAnagramsMethodBitManipulation("BAC D", "ABCD "));
    }
}