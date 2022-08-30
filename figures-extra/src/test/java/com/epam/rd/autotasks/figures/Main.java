package com.epam.rd.autotasks.figures;

import static java.lang.Math.sqrt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import  java.util.regex.Pattern;
import  java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {

        char[] name =new char[] {'P','a','u','l'};
        String boy =new String(name); //1

        Pattern pattern = Pattern.compile("p.+l");
        String inputT = "paul";
        String pat = "p.+l";
        System.out.println(Pattern.matches(pat, inputT));

        String str1 = "Один два,три!четыре;пять шесть.семь";
        Pattern p1 = Pattern.compile(" \s ");
        String s[] = p1.split(str1);
        System.out.println("Исходная строка -> " + str1);
        for (String i : s) {
            System.out.println("Лексема: " + i);
        }
    }
}
