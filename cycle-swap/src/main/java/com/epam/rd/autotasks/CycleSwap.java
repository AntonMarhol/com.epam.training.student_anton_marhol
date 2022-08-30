package com.epam.rd.autotasks;

import java.util.Arrays;

class CycleSwap {
    static void cycleSwap(int[] array) {

        int[] resultArray;
        resultArray = Arrays.copyOf(array, array.length);

        if (!Arrays.equals(new int[]{},array)){
            System.arraycopy(resultArray, resultArray.length - 1, array, 0, 1);
            System.arraycopy(resultArray, 0, array, 1, resultArray.length - 1);
        }
    }

    static void cycleSwap(int[] array, int shift) {

        int[] resultArrayTwo;
        resultArrayTwo = Arrays.copyOf(array,array.length);

        if (shift < array.length){
            System.arraycopy(resultArrayTwo, array.length-shift, array, 0, array.length-(array.length-shift));
            System.arraycopy(resultArrayTwo, 0, array, array.length-(array.length-shift), array.length - shift);
        }
    }
}
