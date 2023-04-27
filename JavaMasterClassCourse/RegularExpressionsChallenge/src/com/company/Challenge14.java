package com.company;

/**
 * Write a regular expression that will match 5-digit US zip codes, and zip codes that contain
 * the optional 4 digits preceded by a dash.
 */

public class Challenge14 {

    public static void main(String[] args) {

        String challenge14 = "11111-1111";
        String challenge14a = "11111";


        // Answer
        System.out.println(challenge14.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge14a.matches("^\\d{5}(-\\d{4})?$"));



        // Extra
        // ^[A-Za-z]\d[A-Za-z][ -]?\d[A-Za-z]\d$
        // letter, number, letter, optional blank and -, number, letter, number
    }
}
