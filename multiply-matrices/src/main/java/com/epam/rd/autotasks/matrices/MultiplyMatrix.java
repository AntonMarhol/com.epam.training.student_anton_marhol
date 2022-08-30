package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class MultiplyMatrix {
    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        // Put your code here
        if (matrix1.length == 0 || matrix2.length == 0)
            return null;

        int[][] matrixNew = new int[matrix1.length][matrix2[0].length];
        int summner = 0;
        int a = 0;
        int p = 0;

        while (p <= matrix1.length-1){

            for (int i = 0; i < matrix1.length; i++) {
                a=0;

                if (p >= matrix1.length)
                    break;

                while (a <= matrix2[0].length-1) {
                    summner = 0;

                    for (int j = 0; j <= matrix2.length - 1; j++) {
                        summner += matrix1[i][j] * matrix2[j][a];
                    }

                    matrixNew[p][a] = summner;
                    a++;
                }
                p++;
            }
        }

        return matrixNew;

    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] a = {
                {2,4},   //{0, 12345},
                {4,5},//{4509, 0},
                {6,3}};//{3, 567} };

        int[][] b = {
                {2,7,6},// {653, 0, 25353},
                {6,3,8}};//{0, 61, 6} };

        int[][] result = multiply(a, b);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
