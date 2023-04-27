package com.company;

/**
 * Write a regular expression that will match the following
 * string in its entirely. Use the String.matches() method to verify your answer.
 */

public class Challenge5 {
    public static void main(String[] args) {

        String challenge5 = "aaabccccccccdddefffg";


        //Answer - could also use *
        System.out.println(challenge5.matches("[a-g]+"));
        // or
        System.out.println(challenge5.matches("[abcdefg]+"));
    }
}
