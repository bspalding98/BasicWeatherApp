package com.company;

/**
 * Replace all occurrences of blank with an underscore for the following string. Print out the resulting string.
 */

public class Challenge4 {

    public static void main(String[] args) {
        String challenge4 = "Replace all blanks with underscores.";

        //Answer
        System.out.println(challenge4.replaceAll(" ", "_"));
        // or
        System.out.println(challenge4.replaceAll("\\s", "_"));
    }
}
