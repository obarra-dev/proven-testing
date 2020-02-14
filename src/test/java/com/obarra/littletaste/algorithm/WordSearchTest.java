package com.obarra.littletaste.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void getIndexesOfMatchedWords() {
    	int d = "dssdrgttfvttuggggkiolo".indexOf("gggg");
    	System.out.println(d);
    	
        char[][] m = {{'o','m','a'},{'o','m','a'},{'o','m','a'}};
        WordSearch.getIndexesOfMatchedWord(m, "oma");
    }
//    @Test
//    public void getIndexesOfMatchedWordsd() {
//        char[][] m = {{'o','m','a','r'},{'o','m','a','r'},{'o','m','a','r'},{'o','m','a','r'}};
//        WordSearch.getIndexesOfMatchedWord(m, "ramo");
//    }
//
//    @Test
//    public void getIndexesOfMatchedWordStrategyCheckCellsAndEightDirections() {
//        char matrix[][] = {{'o','m','a'},{'o','m','a'},{'o','m','a'}};;
//        WordSearch.getIndexesStrategyCheckCellsAndEightDirections(matrix, "oma");
//    }
//    @Test
//    public void getIndexesOfMatchedWordStrategyCheckCellsAndEightDirectionsDER() {
//        char matrix[][] = {{'o','m','a','r'},{'o','m','a','d'},{'o','m','a','f'}};;
//        WordSearch.getIndexesStrategyCheckCellsAndEightDirections(matrix, "omar");
//    }
//
//    @Test
//    public void getIndexesOfMatchedWordStrategyCheckCellsAndEightDirectionsDERf() {
//        char matrix[][] = {{'o','m','a','r'},{'o','m','a','d'},{'o','m','a','f'}};;
//        WordSearch.getIndexesStrategyCheckCellsAndEightDirections(matrix, "aaa");
//    }


}