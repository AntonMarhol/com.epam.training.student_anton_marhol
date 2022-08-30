package com.epam.rd.autotasks;

import java.util.ArrayList;

public class CompleteByRequestTask implements Task {
    boolean complete = false;
    boolean executeComplete = false;

    @Override
    public void execute() {

//        throw new UnsupportedOperationException();

        if (complete == true) executeComplete = true;
    }

    @Override
    public boolean isFinished() {

//        throw new UnsupportedOperationException();

            if (complete == true && executeComplete == true) return true;
            else return false;
    }

    public void complete() {

//        throw new UnsupportedOperationException();

        complete = true;
    }
}
