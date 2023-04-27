package com.company;

import java.util.function.Function;

/**
 * Right now, the function doesn't do anything. Write the code that will execute the function with an argment of "1234567890"
 */

public class Challenge3 {
    public static void main(String[] args) {

        Function<String, String> lambdafunction = s-> {
            StringBuilder returnVal = new StringBuilder();
            for(int i = 0; i < s.length(); i++) {
                if(i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }

            return returnVal.toString();
        };


        //Answer
        System.out.println(lambdafunction.apply("1234567890"));
    }
}
