package com.epam.rd.autotasks;

public class CarouselRun {
    int[] array;
    int noNumber = 0;
    int runOnArray = 0;

    public CarouselRun(int[] array){
        this.array = array;
    }

    public int next() {
        if (array==null) {
        throw new UnsupportedOperationException();
        }

        boolean quitOfWhile = false;
        int isNextResult = 0;

        while (!quitOfWhile) {
            if (runOnArray == array.length) {
                runOnArray = 0;
                noNumber = 0;
            }
            if (array[runOnArray] != 0) {
                isNextResult = array[runOnArray];
                array[runOnArray] = array[runOnArray] - 1;
                runOnArray++;
                break;
            } if (array[runOnArray]==0){
                runOnArray++;
                noNumber++;
            }
            if (noNumber == array.length) {
                isNextResult = -1;
                break;
            }
        }

        return isNextResult;

    }

    public boolean isFinished() {
//        throw new UnsupportedOperationException();
        boolean isFinishedResult = false;
        int noNumber = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                noNumber++;
        }

        if (noNumber == array.length){
        isFinishedResult = true;
        }

        return isFinishedResult;

    }



}
