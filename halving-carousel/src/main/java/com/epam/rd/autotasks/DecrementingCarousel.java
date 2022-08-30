package com.epam.rd.autotasks;

public class DecrementingCarousel {
    private int q;
    private int runNow;
    private int[] carusel;
    protected String callForStart = "decrementingCarusel";

    public DecrementingCarousel(int capacity) {
        carusel = new int [capacity];
    }

    public boolean addElement(int element){
        boolean addElementResult;

        if (carusel == null) { throw new UnsupportedOperationException(); }

        if (q == carusel.length || element <= 0 || runNow == 1) {
            addElementResult = false;
        }
        else {
            carusel[q] = element;
            q++;
            addElementResult = true;
        }
        return addElementResult;
    }

    public CarouselRun run(){
       if (carusel == null) { throw new UnsupportedOperationException(); }

        CarouselRun carouselRun = new CarouselRun(carusel, callForStart);

        if (runNow == 1) return null;
        runNow = 1;

        return carouselRun;

    }
}
