package com.epam.rd.autotasks.meetautocode;

import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        int hours = 0;
        int minutes = 0;
        int secondsOut = 0;

        hours = (int) seconds/3600;
        minutes = (int) ((seconds-(hours*3600))/60);
        secondsOut = seconds-((hours*3600) + (minutes*60));


        hours = (hours >= 24) ? hours = 0 : hours;
        if (minutes < 10 && secondsOut < 10)
            System.out.println(hours + ":" + "0" + minutes + ":" + "0" + secondsOut);
        if (minutes < 10 && secondsOut > 9)
            System.out.println(hours + ":" + "0" + minutes + ":" + secondsOut);
        if (minutes > 9 && secondsOut < 10)
            System.out.println(hours + ":" + minutes + ":" + "0" + secondsOut);
        if (minutes > 9 && secondsOut > 9)
            System.out.println(hours + ":" + minutes + ":" + secondsOut);



    }
}
