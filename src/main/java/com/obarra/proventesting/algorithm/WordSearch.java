package com.obarra.proventesting.algorithm;

public class WordSearch {
    private static int ASCENDENT = 1;
    private static int DECREASE = -1;
    private static int PERMANENT = 0;


    public static int[][] getIndexesStrategyCheckCellsAndEightDirections(char[][] matrix, String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int[] indexes = getIndexesOfWord(matrix, i, j, word);

                if(indexes != null){
                    System.out.println("EXIST between: "+ indexes[0] + ", "+indexes[1] +
                            " ; "+indexes[2] +" , " +indexes[3] );
                }else{
                    System.out.println("der");
                }

            }
        }
        return null;
    }

    private static int[] getIndexesOfWord(char[][] matrix, int indexRow, int indexCol, String word) {
        final int[] directionsX = {PERMANENT, PERMANENT, ASCENDENT, DECREASE, DECREASE, ASCENDENT, DECREASE, ASCENDENT};
        final int[] directionsY = {ASCENDENT, DECREASE, PERMANENT, PERMANENT, DECREASE, DECREASE, ASCENDENT, ASCENDENT};

        if(matrix[indexRow][indexCol] != word.charAt(0)) {
            return null;
        }

        for (int k = 0; k < 8; k++) {
            int indexX = indexCol + directionsX[k];
            int indexY = indexRow + directionsY[k];
            int w;
            for (w=1; w < word.length(); w++) {
                if(indexX >= matrix[0].length || indexY >= matrix.length
                        || indexX < 0 || indexY < 0){
                    break;
                }

                if(matrix[indexY][indexX] != word.charAt(w)) {
                    break;
                }

                indexX = indexX + directionsX[k];
                indexY = indexY + directionsY[k];
            }

            if(w == word.length()) {
                return new int[]{indexRow, indexCol, indexY, indexX};

            }

        }

        return null;
    }



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
