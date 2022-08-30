package com.epam.rd.autotasks.max;

public class MaxMethod<r> {

    public static int max(int[] values) {

        int maxValue = Integer.MIN_VALUE;

        if (values == null) throw new java.lang.UnsupportedOperationException();

        for (int i : values) {
            if (i > maxValue){
                maxValue = i;
            }
        }

        return maxValue;

    }
}
