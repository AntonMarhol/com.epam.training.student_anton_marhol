package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {

        int numberOfStrangers;

        Scanner scannerNumbers = new Scanner(System.in);
        numberOfStrangers = scannerNumbers.nextInt();

        if (numberOfStrangers == 0)
            System.out.println("Oh, it looks like there is no one here");
        else if (numberOfStrangers < 0)
            System.out.println("Seriously? Why so negative?");
        else {
            String [] arrayName = new String[numberOfStrangers];

            for (int i = 0; i < arrayName.length; i++) {
                Scanner scannerName = new Scanner(System.in);
                String nameOfStrangers = scannerName.nextLine();
                arrayName[i] = nameOfStrangers;
            }
            for (int i = 0; i < arrayName.length; i++) {

                System.out.println("Hello, " + arrayName[i]);

            }
        }
    }
}
