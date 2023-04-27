package com.company;

/**
 * Write a regular expression that will match a 5-digit US zip code. Use "11111" as your test string.
 */

public class Challenge12 {
    public static void main(String[] args) {

        String challenge12 = "11111";

        // Answer
        System.out.println(challenge12.matches("^[0-9]{5}$"));
        // or
        System.out.println(challenge12.matches("^\\d{5}$"));

    }
}
