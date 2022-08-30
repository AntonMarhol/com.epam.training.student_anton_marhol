package com.epam.rd.autotasks.intersection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        Line line1 = new Line(x1,y1);
        Line line2 = new Line(x2,y2);

        System.out.println("result is " + line1.intersection(line2));
    }

}
