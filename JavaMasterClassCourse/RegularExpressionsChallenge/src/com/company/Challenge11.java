package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Suppose we have the following string containing points on a graph within curly braces.
 * Extract what's in the curly braces
 */

public class Challenge11 {
    public static void main(String[] args) {

        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";


        // Answer
        String regExp = "((\\d+, \\d+))";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge11);

        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence: " + matcher.group());
        }
    }
}
