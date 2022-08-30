package com.epam.rd.autotasks;

public class CountDownTask implements Task{
    private int value = 0;

    public CountDownTask(int value) {

//      throw new UnsupportedOperationException();
        if (value < 0) value = 0;
        if (value > 0) this.value = value;
        else this.value = 0;
    }

    public CountDownTask() {

    }

    public int getValue() {

//        if (value < 0) throw new UnsupportedOperationException();

        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void execute() {

//        throw new UnsupportedOperationException();

        if (value > 0)
        value--;
    }

    @Override
    public boolean isFinished() {

//        throw new UnsupportedOperationException();

        if (value == 0) return true;
        else return false;
    }
}
