package com.company;

/**
 * Write a regular expression that will match a string that starts with a series of letter. The
 * letter must be followed by a period. After the period, there must be a series of digits. The
 * string "kjisl.22" would match. That string "f5.12a" would not. Use this string to test your
 * regular expression.
 */

public class Challenge7 {
    public static void main(String[] args) {

        String challenge7 = "abcd.135";


        // Answer
        String regExp = "^\\w+\\.\\d+$";
        //Or
        regExp = "^[a-z|A-Z]+\\.\\d+$";
        System.out.println(challenge7.matches(regExp));
    }
}
