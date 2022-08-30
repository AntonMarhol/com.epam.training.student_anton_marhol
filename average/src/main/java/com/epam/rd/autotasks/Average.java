package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {

        boolean endCircleOne = false;

        int i = 0;
        int summ = 0;
        int result = 0;
        int emountOfNumber = 0;

        Scanner scanner = new Scanner(System.in);
        String currentString = scanner.nextLine();

        while (!endCircleOne){
            int minus = 0;
            char digit;
            int currentNumber = 0;

            if (currentString.charAt(i) == ' ') {
                i++;
            }

            if (currentString.charAt(i) == '-') {
                minus = 1;
                i++;
            }

            boolean endCircleTwo = false;

            while (!endCircleTwo){
                digit = currentString.charAt(i);
                currentNumber *=10;
                currentNumber += Character.getNumericValue(digit);

                if (currentString.charAt(i+1) == ' ') {
                    endCircleTwo = true;
                    if (currentString.charAt(i+2) == '0')
                        endCircleOne = true;
                }

                i++;
            }
            emountOfNumber++;

            if (minus == 1) {
                currentNumber *= -1;
            }
            summ += currentNumber;
        }

        result = (int) summ/emountOfNumber;
        System.out.println(result);

    }

}