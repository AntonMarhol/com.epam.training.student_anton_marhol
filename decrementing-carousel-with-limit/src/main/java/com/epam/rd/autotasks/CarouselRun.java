package com.epam.rd.autotasks;

public class CarouselRun {
    private int[] array;
    private int noNumber = 0;
    private int goOnTheArray = 0;
    private String collection;
    private int actual;
    private int back;
    int out = 0;

    public CarouselRun(int[] array, String collection, int actual) {
        this.array = array;
        this.collection = collection;
        this.actual = actual;
    }

    public CarouselRun(int[] array, String who) {
        this.array = array;
        this.collection = who;
    }

    public int next() {
        boolean boo = false;

        if (array == null) {
            throw new UnsupportedOperationException();
        }

        if (collection == "graduallyCarusel" && back == actual) {
            return  -1;
        }

        while (!boo) {
            if (goOnTheArray == array.length) {
                goOnTheArray = 0;
                noNumber = 0;
            }

            if (array[goOnTheArray] > 0) {
                out = array[goOnTheArray];
                array[goOnTheArray] = array[goOnTheArray] - 1;
                goOnTheArray++;
                back++;
                break;
            }
            if (array[goOnTheArray] == 0) {
                goOnTheArray++;
                noNumber++;
            }

            if (noNumber == array.length) {
                out = -1;
                break;
            }
        }
        return out;
    }

    public boolean isFinished() {
        if (array==null) { throw new UnsupportedOperationException(); }

        boolean isFinishedResult = false;
        int isArrayEnd = 0;

        if (isEmpty(array) == 0) return true;

        if (collection == "graduallyCarusel" && back >= actual) { return true; }
        if (collection == "decrementingCarusel" ) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0)
                    isArrayEnd++;
            }

            if (isArrayEnd == array.length) {
                isFinishedResult = true;
            }
        }
        return isFinishedResult;

    }

    public int isEmpty (int[] arr) {
        int isEmptyResult = 0;
        for (int i = 0; i < array.length; i++) {
            isEmptyResult = array[i] + isEmptyResult;
        }
        return isEmptyResult;
    }

}

