package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge10 {
    public static void main(String[] args) {
        String string = "abcd.135uvqz.7tzik.999";
        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.printf("From start = %d to end = %d%n", matcher.start(), matcher.end() - 1);
        }
    }
}
