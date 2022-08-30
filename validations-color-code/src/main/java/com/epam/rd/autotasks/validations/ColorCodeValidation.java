package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorCodeValidation {


    public static boolean validateColorCode(String color) {

        if (color == null || color.length() == 0) return false;

        Pattern pattern = Pattern.compile("#[09abcdefABCDEF]{3}||#[09abcdefABCDEF]{6}||#[09]{3,6}||#([0-9][a-zA-Z]){3}");
        Matcher matcher = pattern.matcher(color);

        if (matcher.matches()) return true;
        else return false;

    }
}





