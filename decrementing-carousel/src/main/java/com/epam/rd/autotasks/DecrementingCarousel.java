package com.epam.rd.autotasks;

public class DecrementingCarousel {

    private int caruselIsEnd;
    private int runNow;
    private int[] carusel;

    public DecrementingCarousel(int capacity) {
        carusel = new int [capacity];
    }

    public boolean addElement(int element){
        boolean isAddElement;

//        if (element)
//        throw new UnsupportedOperationException();

        if ( caruselIsEnd == carusel.length || element <= 0 || runNow == 1) {
            isAddElement = false;
        }
        else {
            carusel[caruselIsEnd] = element;
            caruselIsEnd++;
            isAddElement = true;
        }
        return isAddElement;
    }

    public CarouselRun run(){
//          throw new UnsupportedOperationException();

        CarouselRun goCarusel = new CarouselRun(carusel);

        if (runNow == 1)
            return null;
        runNow = 1;

        return goCarusel;

    }
}
