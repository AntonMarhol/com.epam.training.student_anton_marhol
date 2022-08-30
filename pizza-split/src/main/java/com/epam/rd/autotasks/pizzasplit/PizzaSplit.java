package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder

        int piecesForPeople;
        int numberOfPeople;
        boolean outWhile = false;
        int numberOfPizzas = 1;

        Scanner scanner = new Scanner(System.in);
            numberOfPeople = scanner.nextInt();
            piecesForPeople = scanner.nextInt();

        while (!outWhile){
            if ((numberOfPizzas*piecesForPeople) % numberOfPeople == 0)
                break;
            else
                numberOfPizzas++;
        }

        System.out.println(numberOfPizzas);

    }
}
