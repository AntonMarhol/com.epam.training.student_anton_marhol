package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Exception;

public class CatchEmAll {

    //You may set another exception in this field;
    static Exception exception = new ArithmeticException();

    public static void riskyMethod() throws Exception {
        throw exception;
    }

    public static void main(String[] args) throws Exception {

        try{
        riskyMethod();
        }
        catch (FileNotFoundException f){
            throw new IllegalArgumentException("Resource is missing", f);
        }
        catch (IOException iio){
            throw new IllegalArgumentException("Resource error", iio);
        }
        catch (ArithmeticException | NumberFormatException n) {
            System.err.println(n.getMessage());
        }
    }
}
