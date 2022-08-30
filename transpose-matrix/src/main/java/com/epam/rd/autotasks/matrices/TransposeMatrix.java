package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {

        if (matrix.length == 0) return null;

        int deepLength = matrix[0].length;
        int highLength = matrix.length;
        int newMatrix[][] = new int[deepLength][highLength];

        for (int i = 0; i <= matrix.length-1; i++) {
            for (int p = 0; p <= matrix[0].length-1; p++) {
                newMatrix[p][i] = matrix[i][p];
            }
        }

        return newMatrix;

    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] matrix = {
                {1, 2},
                {7, -13} };

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }

}
