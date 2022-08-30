package com.epam.rd.autotasks.meetastranger;

import java.util.Scanner;

public class MeetAStranger {
    public static void main(String[] args) {

        Scanner scant = new Scanner(System.in);
        String name;

        name = scant.nextLine();

        System.out.print("Hello, " + name);
    }
}
