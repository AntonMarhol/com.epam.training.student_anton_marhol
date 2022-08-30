package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class SumOfEvenNumbers {

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 8, 15, 199};

        System.out.println(sum(array));
    }

    public static int sum(int[] array){

//        throw new UnsupportedOperationException();

        int summEvenNumber = 0;
        int[] emptyArray = new int[0];

        if (Arrays.equals(emptyArray, array) || array == null) return 0;

        for (int currentNumber : array) {
            if (currentNumber % 2 == 0) summEvenNumber += currentNumber;
        }

        return summEvenNumber;

    }
}
