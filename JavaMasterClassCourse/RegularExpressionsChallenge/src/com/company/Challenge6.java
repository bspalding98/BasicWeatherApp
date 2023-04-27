package com.company;

/**
 * Write a regular expression that will ONLY match challenge 5 string in its entirety
 */

public class Challenge6 {
    public static void main(String[] args) {

        String challenge5 = "aaabccccccccdddefffg";


        //Answer
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        // or
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));
    }
}
