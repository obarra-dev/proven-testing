package com.obarra.littletaste.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void getIndexesOfMatchedWords() {
        char[][] m = {{'o','m','a'},{'o','m','a'},{'o','m','a'}};
        WordSearch.getIndexesOfMatchedWord(m, "oma");
    }
    @Test
    public void getIndexesOfMatchedWordsd() {
        char[][] m = {{'o','m','a','r'},{'o','m','a','r'},{'o','m','a','r'},{'o','m','a','r'}};
        WordSearch.getIndexesOfMatchedWord(m, "ramo");
    }
}