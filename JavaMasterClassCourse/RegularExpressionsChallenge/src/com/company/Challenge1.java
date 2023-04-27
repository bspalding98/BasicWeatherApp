package com.company;

/**
 * Write the string literal regular expression that will match the follow String. Use the
 * String.matches() method to verify your answer.
 */

public class Challenge1 {
    public static void main(String[] args) {

        String challenge1 = "I want a bike.";

        //Answer
        System.out.println(challenge1.matches("I want a bike\\.")); // . represents any character remember
    }
}
