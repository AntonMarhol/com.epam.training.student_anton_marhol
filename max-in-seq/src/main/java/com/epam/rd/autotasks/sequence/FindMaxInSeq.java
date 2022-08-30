package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        int maxNumber = Integer.MIN_VALUE;
        int currentNumber = 0;
        String currentString;
        char charToNumber;
        int i = 0;
        int minus = 0;

        Scanner scanner = new Scanner(System.in);
        currentString = scanner.nextLine();

            while (currentString.charAt(i) != '0') {

                if (currentString.charAt(i) == '-') {
                    minus = 1;
                    i++;
                }

                if (currentString.charAt(i) == ' ') {
                    minus = 0;
                    currentNumber = 0;
                    i++;
                }

                if (currentString.charAt(i) == '0')
                    break;

                while (currentString.charAt(i) != ' '){
                    charToNumber = currentString.charAt(i);
                    currentNumber *= 10;
                    currentNumber += Character.getNumericValue(charToNumber);

                    if (currentString.charAt(i+1) == ' ' && minus == 1){
                        currentNumber *= -1;
                    }
                    i++;
                }

                if (currentNumber > maxNumber) {
                    maxNumber = currentNumber;
                }
            }

        return maxNumber;
    }



    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
