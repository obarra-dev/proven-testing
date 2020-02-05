package com.obarra.littletaste.algorithm;

public class WordSearch {
    public static int[][] getIndexesOfMatchedWord(char[][] wordSearch, String word){
        int[][] indexes = new int[4][];


        int quantityComparisons = wordSearch.length / 2 ;
        int quantityElement = wordSearch.length - 1;
        boolean isEven = (wordSearch.length % 2) == 0? false:true;

        if(isEven){
            for (int j = 0; j <= quantityElement; j++) {
                //top horizontal left to right
                if(wordSearch[wordSearch.length / 2 +1][j] == word.charAt(j)){
                    System.out.println(word.charAt(j));
                }

                //top horizontal right to left
                if(wordSearch[wordSearch.length / 2 + 1][quantityElement - j]  == word.charAt(j)){
                    System.out.println(word.charAt(j));
                }
            }
        }



        for (int k = 0; k < quantityComparisons; k++) {
            for (int j = 0; j <= quantityElement; j++) {
                //top horizontal left to right
                if(wordSearch[k][j] == word.charAt(j)){
                    System.out.println(word.charAt(j));
                }

                //top horizontal right to left
                if(wordSearch[k][quantityElement - j]  == word.charAt(j)){
                    System.out.println(word.charAt(j));
                }

                //low horizontal left to right
                if(wordSearch[quantityElement - k][j] == word.charAt(j)){
                    System.out.println(word.charAt(j));
                }

                //low horizontal right to left
                if(wordSearch[quantityElement - k][quantityElement - j]  == word.charAt(j)){
                    System.out.println(word.charAt(j));
                }
            }
        }

        return null;
    }

    private static void saveInitialIndixes(int k, int j) {
    }
}
