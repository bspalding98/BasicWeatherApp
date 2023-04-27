package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In the last challenge, we used the same regular expression twice. Use the
 * Matcher.matches() method to check for matches, instead of String.matches(), for the
 * regular expression that uses \w+. Hint: You'll have to compile a pattern
 */

public class Challenge3 {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";


        //Answer

        String wordPattern = "I want a \\w+\\.";
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());



    }
}
