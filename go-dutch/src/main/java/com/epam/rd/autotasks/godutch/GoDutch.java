package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {

        int payForOne = 0;
        Scanner scanner = new Scanner(System.in);
        int billAmount = scanner.nextInt();
        int amountOfFriends = scanner.nextInt();

        if (billAmount >= 0 && amountOfFriends >0 ){
            billAmount += billAmount/10;
            payForOne = billAmount/amountOfFriends;
            System.out.println(payForOne);
        }
        if (billAmount < 0) {
            System.out.println("Bill total amount cannot be negative");
        }
        else if (amountOfFriends <=0) {
            System.out.println("Number of friends cannot be negative or zero");
        }
    }
}
