package com.epam.rd.autotasks.validations;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {

        if (email == null || email.length() == 0) return false;

        Pattern pattern = Pattern.compile("[a-zA-Z]+_[a-zA-Z]+[1-9]*@epam.com");
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) return true;
        else return false;

    }
}





