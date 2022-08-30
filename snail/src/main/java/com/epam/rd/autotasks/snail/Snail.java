package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree

        int a;
        int b;
        int h;
        int getTop = 0;
        int days = 0;
        Scanner scanner = new Scanner(System.in);
        boolean reach = false;

        a = scanner.nextInt();
        b = scanner.nextInt();
        h = scanner.nextInt();

        if (a < b && a != h && h > a || a == b && h > b) System.out.println("Impossible");
        else {
            while (!reach) {
                days++;
                getTop += a;
                if (getTop >= h) break;
                getTop -= b;
            }
                System.out.println(days);
        }
    }
}
