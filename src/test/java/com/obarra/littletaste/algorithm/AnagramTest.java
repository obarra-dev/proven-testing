package com.obarra.littletaste.algorithm;

import org.junit.Assert;
import org.junit.Test;

public class AnagramTest {

    @Test
    public void areAnagramsMethodCountAndCompareWhenAreDifferentForOneLetter() {
        Assert.assertEquals(false, Anagram.areAnagramsMethodCountAndCompare("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenAreOKAnagrams() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodCountAndCompare("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenTheWordsHasTwoLetters() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodCountAndCompare("go", "og"));
    }

    @Test
    public void areAnagramsMethodCountAndCompareWhenTheWordHasSpace() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodCountAndCompare("BAC D", "ABCD "));
    }


    @Test
    public void areAnagramsMethodSortAndCompareWhenAreDifferentForOneLetter() {
        Assert.assertEquals(false, Anagram.areAnagramsMethodSortAndCompare("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenAreOKAnagrams() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodSortAndCompare("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenTheWordsHasTwoLetters() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodSortAndCompare("go", "og"));
    }

    @Test
    public void areAnagramsMethodSortAndCompareWhenTheWordHasSpace() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodSortAndCompare("BAC D", "ABCD "));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenAreDifferentForOneLetter() {
        Assert.assertEquals(false, Anagram.areAnagramsMethodCheckingOff("mmmmmmmaaaaao", "mmmmmmmaaaaaa"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenAreOKAnagrams() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodCheckingOff("mariela", "lamarie"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenTheWordsHasTwoLetters() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodCheckingOff("go", "og"));
    }

    @Test
    public void areAnagramsMethodCheckingOffWhenTheWordHasSpace() {
        Assert.assertEquals(true, Anagram.areAnagramsMethodCheckingOff("BAC D", "ABCD "));
    }



}