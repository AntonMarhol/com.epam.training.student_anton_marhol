package com.epam.rd.autotasks;

public class CarouselRun{
    private int[] array;
    private int noNumber = 0;
    private int q = 0;
    private String who;
    int minus = 1;


    public CarouselRun(int[] array, String who){
        this.array = array;
        this.who = who;
    }

    public int next() {
        if (array==null) {
            throw new UnsupportedOperationException();
        }

        boolean qaz = false;
        int out = 0;

        while (!qaz) {
            if (q == array.length) {
                q = 0;
                noNumber = 0;
                minus++;
            }
            if (array[q] != 0) {
                out = array[q];
                if (who == "decrementingCarusel"){ array[q] = array[q] - 1; }
                if (who == "graduallyCarusel") {
                     array[q] = (array[q] - minus > 0 ? array[q] = array[q] - minus : 0);
                }
                q++;
                break;
            } if (array[q]==0){
                q++;
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

        boolean too = false;
        int noNum=0;

        for (int i = 0; i < array.length; i++) {
            if (array[i]==0)
                noNum++;
        }

        if (noNum == array.length){
            too = true;
        }

        return too;
    }
}
