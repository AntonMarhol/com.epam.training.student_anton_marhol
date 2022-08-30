package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private int q;
    private int runNow;
    private int[] carusel;
    protected String collection = "decrementingCarusel";
    int action = 0;

    public DecrementingCarousel() {

    }

    public DecrementingCarousel(int capacity) {
        carusel = new int [capacity];
    }

    public boolean addElement(int element){
        boolean boolRet;

        if (carusel == null) { throw new UnsupportedOperationException(); }

        if ( q == carusel.length || element <= 0 || runNow == 1) {
            boolRet = false;
        }
        else {
            carusel[q] = element;
            q++;
            boolRet = true;
        }
        return boolRet;
    }

    public CarouselRun run(){
        if (carusel == null) {
            throw new UnsupportedOperationException();
        }

        CarouselRun carouselRun = new CarouselRun(carusel, collection, action);

        if (runNow == 1)
            return null;
        runNow = 1;
        return carouselRun;
    }
}

