package com.obarra.littletaste.algorithm;

public class Matrix {
	
	private static int ASCENDENT = 1;
	private static int DECREASE = -1;
	private static int PERMANENT = 0;
	
	
	public static void printMatched(char[][] matrix, String word) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(existWord(matrix, i, j, word)) {
					System.out.println("EXIST at: "+ i + "; "+j);
				}
			}
		}
		
	}

	private static boolean existWord(char[][] matrix, int i, int j, String word) {
		final int[] directionsX = {PERMANENT, PERMANENT, ASCENDENT, DECREASE, DECREASE, ASCENDENT, DECREASE, ASCENDENT};
		final int[] directionsY = {ASCENDENT, DECREASE, PERMANENT, PERMANENT, DECREASE, DECREASE, ASCENDENT, ASCENDENT};
		
		if(matrix[i][j] != word.charAt(0)) {
			return false;
		}
		
		for (int k = 0; k < 8; k++) {
			int w, der;
			int indexX = i + directionsX[k];
			int indexY = j + directionsX[k];
			
			for (w=0; w < word.length(); w++) {
				if(matrix[indexX][indexY] != word.charAt(w)) {
					break;
				}
				indexX = indexX + directionsX[k];
				indexY = indexY + directionsY[k];
			}
			
			if(w == word.length()) {
				return true;
			}
			
		}
		
		return false;
	}

}
