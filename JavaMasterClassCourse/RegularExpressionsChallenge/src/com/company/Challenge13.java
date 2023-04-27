package com.company;

/**
 * US zip codes can be followed by a dash and another four numbers. Write a regular expression
 * that will amtch those zip codes. Use "11111-1111" as you test string.
 */

public class Challenge13 {
    public static void main(String[] args) {

        String challenge13 = "11111-1111";


        // Answer
        System.out.println(challenge13.matches("^\\d{5}-\\d{4}$"));
    }
}
