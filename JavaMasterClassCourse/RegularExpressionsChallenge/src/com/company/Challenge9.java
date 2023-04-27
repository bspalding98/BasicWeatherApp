package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Let's suppose we're reading strings that match the patterns we used in challenge 7 and 8
 * from a file. Tabs are used to separate the matches, with one exception. The last match is
 * followed by a newline. Our revised challenge 8 string would look like this:
 *
 * Revise the regular expression accordingly and extract all numbers, as we did in challenge 8.
 */

public class Challenge9 {
    public static void main(String[] args) {

        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";


        // Answer
        String regExp = "\\d+";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge9);

        int count = 0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence: " + matcher.group());
        }
    }
}
