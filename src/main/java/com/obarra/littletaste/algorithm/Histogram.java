package com.obarra.littletaste.algorithm;

public class Histogram {

    public static void printHistogramHorizontal(final int[] values){
        for(int i = 0; i < values.length; i++){
            System.out.print((i+1) +"| " + values[i] + " | ");
            for(int j = 0; j < values[i]; j++){
                System.out.print(" m ");
            }
            System.out.println();
        }
    }

    public static void printHistogramRowByRow(final int[] values){
        int maximumValue = getMaximumValue(values);
        for(int j = maximumValue; j > 0; j--){
            System.out.print(j +"|");
            for(int i = 0; i < values.length; i++){
                if(j <= values[i]){
                    System.out.print(" m ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

        for(int i = 0; i < values.length + 1; i++){
            System.out.print("---");
        }
        System.out.println();

        System.out.print("  ");
        for(int i = 0; i < values.length; i++){
            System.out.print(" "+ (i + 1) + " ");
        }

        System.out.println();
    }

    public static char[][] generateMatrixHistogramRowByRow(final int[] values){
        int maximumValue = getMaximumValue(values);
        char[][] matrixHistogram = new char[maximumValue][values.length];

        for (int j = 0; j < maximumValue; j++){
            for (int i = 0; i < values.length; i++){
                if(j < values[i]){
                    matrixHistogram[j][i] = 'm';
                }
            }
        }
        return matrixHistogram;
    }

    private static int getMaximumValue(int[] values) {
        int maximum = 0;
        for(int i = 0; i < values.length; i++){
            if(i == 0 || maximum < values[i]){
                maximum = values[i];
            }
        }

        return maximum;
    }

    public static void printMatrixHistogram(final char[][] matrixHistogram){
        for(int i = matrixHistogram.length - 1; i >= 0;  i--){
            for (int j = 0; j < matrixHistogram[i].length; j++){
                System.out.print(matrixHistogram[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
