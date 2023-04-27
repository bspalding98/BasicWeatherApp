package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Modify the regular expression in challenge 7 to use a group, so that we can print all the figits that occur
 * in a string that contains multiple occurrences of the pattern. Write all the code required to accomplish
 * this (create a pattern and matcher, etc.). Use the follow string to test your code:
 *
 * There are three occurrences of the pattern we looked for in challenge #7. When you run your code,
 * you should see 135, 7, and 999 printed to the console
 */

public class Challenge8 {
    public static void main(String[] args) {

        String challenge8 = "abcd.135uvqz.7tzik.999";


        // Answer
        String regExp = "\\d+";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge8);

        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence: " + matcher.group());
        }
    }
}
