package com.epam.rd.autotasks;

public class CarouselRun {
    private int[] array;
    private int noNumber = 0;
    private int q = 0;
    private String nameOfClassThatCallForStart;

    public CarouselRun(int[] array, String nameOfClassThatCallForStart){
        this.array = array;
        this.nameOfClassThatCallForStart = nameOfClassThatCallForStart;
    }


    public int next() {
        if (array==null) {
            throw new UnsupportedOperationException();
        }

        boolean booleanForWhileLoop = false;
        int intToReturn = 0;

        while (!booleanForWhileLoop) {
            if (q == array.length) {
                q = 0;
                noNumber = 0;
            }
            if (array[q] != 0) {
                intToReturn = array[q];
                if (nameOfClassThatCallForStart == "decrementingCarusel"){ array[q] = array[q] - 1; }
                if (nameOfClassThatCallForStart == "halvingCarusel") array[q] = Math.abs(array[q] /2);
                q++;
                break;
            } if (array[q]==0){
                q++;
                noNumber++;
            }
            if (noNumber == array.length) {
                intToReturn = -1;
                break;
            }
        }
        return intToReturn;
    }

    public boolean isFinished() {

        if (array==null) { throw new UnsupportedOperationException(); }

        int noNumber = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]==0)
                noNumber++;
        }

        return (noNumber == array.length ? true : false);
    }

}
