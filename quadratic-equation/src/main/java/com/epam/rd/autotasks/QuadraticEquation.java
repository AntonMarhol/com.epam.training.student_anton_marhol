package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double xOne;
        double xTwo;
        double square;

            square = (b * b) - (4 * a * c);
            xOne = (-b - sqrt(square)) / (2 * a);

            square = (b * b) - (4 * a * c);
            xTwo = (-b + sqrt(square)) / (2 * a);

        if (Double.isNaN(xOne) && Double.isNaN(xTwo)) System.out.println("no roots");
        else if (xOne == xTwo ) System.out.println(xOne );
        else System.out.println(xOne + " " + xTwo);
    }
}