package com.company;

import java.util.function.Function;

/**
 * Using the bonus version, call the method with the lambdaFunction we created earlier and the string "1234567890".
 * Print the result returned from the method
 */

public class Challenge5 {

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
        System.out.println(everySecondCharacter("1234567890", lambdafunction));
    }

    public static String everySecondCharacter(String arg, Function<String, String> func) {
        return func.apply(arg);
    }
}
