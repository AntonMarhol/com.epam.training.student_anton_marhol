package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {

// throw new UnsupportedOperationException();

        if (sample == null || words == null) return 0;

        int q = 0;
        String word;

        Pattern pattern = Pattern.compile("[ \\t\\n]*");
        Matcher matcher = pattern.matcher(sample);
        sample = matcher.replaceAll("");

        Pattern pattern1 = Pattern.compile("\\b[a-zA-Z0-9]+\\b");
        Pattern pattern2 = Pattern.compile("[ \\t\\n]");
        Pattern pattern3 = Pattern.compile(sample, Pattern.CASE_INSENSITIVE);
        Pattern pattern4 = Pattern.compile("\\W*\\b[a-zA-Z0-9]+\\b\\W*");

        for (int i = 0; i < words.length; i++) {
            Matcher sq = pattern4.matcher(words[i]);

            if (sq.matches()) {
                Matcher s1 = pattern2.matcher(words[i]);
                word = s1.replaceAll("");
            }
            else word = words[i];

            if (pattern1.matches("\\b[a-zA-Z0-9]+\\b", word)) {
                Matcher m = pattern3.matcher(word);
                    if (m.matches()) q++;
            }
        }
        return q;
    }

    public static String[] splitWords(String text) {
//        throw new UnsupportedOperationException();

        if (text == "" || text == null) return null;

        Pattern pattern = Pattern.compile("[ ,.;:/!]+");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ");

        Pattern pattern1 = Pattern.compile("^ \\b");
        Matcher matcher1 = pattern1.matcher(text);
        text = matcher1.replaceFirst("");

        Pattern pattern2 = Pattern.compile("[ ,.;:?!]+");
        String strings[] = pattern2.split(text);

        if (strings == null || strings.length == 0) return null;
        else return strings;

    }

    public static String convertPath(String path, boolean toWin) {
//        throw new UnsupportedOperationException();

        String stringOfConvertPath = "";

        if (path == null || path == "") return null;

        if (toWin == true){                                                                 // конвертация в Win
            Pattern pattern = Pattern.compile("(C:\\\\)?(\\.\\\\)?([a-zA-Z0-9._ ]+\\\\?)*(\\.[a-z]+)?"); // выражение Win
            Matcher matcher = pattern.matcher(path);

            if (matcher.matches()) return path;
            else {
                pattern = Pattern.compile("(\\~\\/)([a-zA-Z0-9._ ]\\/?)*(\\.[a-z]+)?");
                matcher = pattern.matcher(path);

                if (matcher.matches()) {
                    pattern = Pattern.compile("\\~");
                    matcher = pattern.matcher(path);
                    stringOfConvertPath = matcher.replaceFirst("C:\\\\User");
                    pattern = Pattern.compile("\\/");
                    matcher = pattern.matcher(stringOfConvertPath);
                    stringOfConvertPath = matcher.replaceAll("\\\\");

                    return stringOfConvertPath;
                }

                pattern = Pattern.compile("(\\~)([a-zA-Z0-9._ ]\\/?)*(\\.[a-z]+)?");
                matcher = pattern.matcher(path);

                if (matcher.matches()) {
                    pattern = Pattern.compile("\\~");
                    matcher = pattern.matcher(path);
                    stringOfConvertPath = matcher.replaceFirst("C:\\\\User");
                    pattern = Pattern.compile("\\/");
                    matcher = pattern.matcher(stringOfConvertPath);
                    stringOfConvertPath = matcher.replaceAll("\\\\");

                    return stringOfConvertPath;
                }

                pattern = Pattern.compile("\\/([a-zA-Z0-9._ ]\\/?)*(\\.[a-z]+)?");
                matcher = pattern.matcher(path);

                if (matcher.matches()) {
                    pattern = Pattern.compile("\\/");
                    matcher = pattern.matcher(path);
                    stringOfConvertPath = matcher.replaceFirst("C:\\\\");
                    pattern = Pattern.compile("\\/");
                    matcher = pattern.matcher(stringOfConvertPath);
                    stringOfConvertPath = matcher.replaceAll("\\\\");

                    return stringOfConvertPath;
                }

                pattern = Pattern.compile("\\.{1,2}(\\/([a-zA-Z0-9._ ]\\/?)*(\\.[a-z]+)?)?");
                matcher = pattern.matcher(path);

                if (matcher.matches()) {

                    pattern = Pattern.compile("\\.");
                    matcher = pattern.matcher(path);
                    stringOfConvertPath = matcher.replaceAll("\\.");
                    pattern = Pattern.compile("\\/");
                    matcher = pattern.matcher(stringOfConvertPath);
                    stringOfConvertPath = matcher.replaceAll("\\\\");

                    return stringOfConvertPath;
                }

                pattern = Pattern.compile("[a-z]+(\\/[a-z.]+)+");
                matcher = pattern.matcher(path);

                if (matcher.matches()) {

                    pattern = Pattern.compile("\\.");
                    matcher = pattern.matcher(path);
                    stringOfConvertPath = matcher.replaceAll("\\.");
                    pattern = Pattern.compile("\\/");
                    matcher = pattern.matcher(stringOfConvertPath);
                    stringOfConvertPath = matcher.replaceAll("\\\\");

                    return stringOfConvertPath;
                }

                else return null;

            }

        }

        if (toWin == false) {                                                                    // конвертация в Unix
            Pattern pattern = Pattern.compile("\\~?\\/?([a-zA-Z0-9._ ]\\/?)*(\\.[a-z]+)?");
            Matcher matcher = pattern.matcher(path);

            if (matcher.matches()) return path;

            else {

                pattern = Pattern.compile("C:\\\\User(\\\\)?([a-zA-Z0-9._ ]+\\\\?)*(\\.[a-z]+)?");
                matcher = pattern.matcher(path);

                if (matcher.matches()) {

                    pattern = Pattern.compile("C:\\\\User");
                    matcher = pattern.matcher(path);
                    stringOfConvertPath = matcher.replaceFirst("\\~");

                    pattern = Pattern.compile("\\\\");
                    matcher = pattern.matcher(stringOfConvertPath);
                    stringOfConvertPath = matcher.replaceAll("\\/");

                    return stringOfConvertPath;
                }

                pattern = Pattern.compile("(C:\\\\)([a-zA-Z0-9._ ]\\\\?)*(\\.[a-z]+)?");
                matcher = pattern.matcher(path);

                if (matcher.matches()) {
                    pattern = Pattern.compile("C:\\\\");
                    matcher = pattern.matcher(path);
                    stringOfConvertPath = matcher.replaceFirst("\\/");

                    pattern = Pattern.compile("\\\\");
                    matcher = pattern.matcher(stringOfConvertPath);
                    stringOfConvertPath = matcher.replaceAll("\\/");

                    return stringOfConvertPath;
                }

                pattern = Pattern.compile("\\.{1,2}(\\\\([a-zA-Z0-9._ ]\\\\?)*(\\.[a-z]+)?)?");;
                matcher = pattern.matcher(path);

                if (matcher.matches()) {
                    pattern = Pattern.compile("\\.");
                    matcher = pattern.matcher(path);
                    stringOfConvertPath = matcher.replaceAll("\\.");
                    pattern = Pattern.compile("\\\\");
                    matcher = pattern.matcher(stringOfConvertPath);
                    stringOfConvertPath = matcher.replaceAll("\\/");

                    return stringOfConvertPath;
                }

                pattern = Pattern.compile("[a-z]+(\\\\[a-z.]+)+");
                matcher = pattern.matcher(path);

                if (matcher.matches()) {
                        pattern = Pattern.compile("\\.");
                        matcher = pattern.matcher(path);
                        stringOfConvertPath = matcher.replaceAll("\\.");
                        pattern = Pattern.compile("\\\\");
                        matcher = pattern.matcher(stringOfConvertPath);
                        stringOfConvertPath = matcher.replaceAll("\\/");

                        return stringOfConvertPath;
                }
                else return null;
            }
        }
        return null;
    }

    public static String joinWords(String[] words) {
//        throw new UnsupportedOperationException();

        int isEmpty = 0;
        int t = 0;
        String text = "";

        Pattern p = Pattern.compile("");

        if (words == null) return null;

        for (int i = 0; i < words.length; i++) {
            Matcher m = p.matcher(words[i]);
            if (m.matches()) isEmpty++;
            else {
                if (t == 0) text += "[";
                if (t > 0) text += ", ";
                text += words[i];
                t++;
            }
            if (i+1 == words.length) text += "]";
        }

        if (isEmpty == words.length) return null;
        else return text;

    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}