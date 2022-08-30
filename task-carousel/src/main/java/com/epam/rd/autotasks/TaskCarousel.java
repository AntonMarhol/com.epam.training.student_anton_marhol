package com.epam.rd.autotasks;


import java.util.ArrayList;

public class TaskCarousel {
    int capacity;
    int caruselRun;
    CountDownTask countDownTask = new CountDownTask();
    CompleteByRequestTask completeByRequestTask = new CompleteByRequestTask();
    ArrayList<Object> carusel;

    public TaskCarousel(int capacity) {
        if (capacity == 0) throw new UnsupportedOperationException();
        if (capacity > 0) {
            carusel = new ArrayList<>(capacity);
            this.capacity = capacity;
        }
    }

    public TaskCarousel() {
    }

    public boolean addTask(Task task) {

       if(task == null) throw new UnsupportedOperationException();

        if (carusel.size() < capacity) {
            if (task instanceof CountDownTask) {
                countDownTask = (CountDownTask) task;
                if (countDownTask.getValue() > 0) {
                    return (carusel.add(task));
                }
            }
            if (task instanceof CompleteByRequestTask) {
                return (carusel.add(task));
            }
        }
        return false;
    }


    public boolean execute() {

//        throw new UnsupportedOperationException();

        if (isEmpty() == false) {

            while (true) {
                if (carusel.get(caruselRun) != null) {

                    if (carusel.get(caruselRun) instanceof CountDownTask) {
                        countDownTask = (CountDownTask) carusel.get(caruselRun);
                        countDownTask.setValue(countDownTask.getValue() - 1);

                        if (countDownTask.getValue() == 0) carusel.remove(caruselRun);
                        else caruselRun ++;

                        if (caruselRun >= carusel.size()) caruselRun = 0;
                        return true;
                    }

                    if (carusel.get(caruselRun) instanceof CompleteByRequestTask) {
                        completeByRequestTask = (CompleteByRequestTask) carusel.get(caruselRun);

                        if (completeByRequestTask.complete == true) carusel.remove(caruselRun);
                        else caruselRun ++;

                        if (caruselRun >= carusel.size()) caruselRun = 0;
                        return true;
                    }
                }

                if (isEmpty() == true) return false;
            }
        }
        return false;
    }

    public boolean isFull() {

        //        throw new UnsupportedOperationException();

        return (carusel.size() == capacity ? true : false);

    }

    public boolean isEmpty() {

        //        throw new UnsupportedOperationException();

        return (carusel.isEmpty() ? true : false);

    }
}
