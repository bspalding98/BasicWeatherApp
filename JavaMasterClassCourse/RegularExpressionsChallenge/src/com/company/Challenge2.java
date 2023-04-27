package com.company;

import org.w3c.dom.ls.LSOutput;

/**
 * Write a regular expression that will match "I want a bike." and "I want a ball." Verify your answer
 * using the matches() method.
 */

public class Challenge2 {
    public static void main(String[] args) {

        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";


        //Answer
        System.out.println(challenge1.matches("I want a \\w+\\."));
        System.out.println(challenge2.matches("I want a \\w+\\."));
        // \\w matches a-z, A-Z, 0-9, and _
        // + means at least 1 or more


        //another
        String regExp = "I want a (bike|ball)\\.";
        System.out.println(challenge1.matches(regExp));
        System.out.println(challenge2.matches(regExp));


    }
}
