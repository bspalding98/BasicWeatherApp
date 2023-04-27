package com.company;

import java.util.function.Function;

/**
 * Make the method a lambda expression
 */

public class Challenge2 {
    public static void main(String[] args) {
        System.out.println("HI");
    }

//    public static String everySecondChar(String source) {
//        StringBuilder returnVal = new StringBuilder();
//        for(int i = 0; i < source.length(); i++) {
//            if(i % 2 == 1) {
//                returnVal.append(source.charAt(1));
//            }
//        }
//
//        return returnVal.toString();
//    }

    //Answer
    // Maps to function interface. String, string
    Function<String, String> lambdafunction = s-> {
        StringBuilder returnVal = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(i % 2 == 1) {
                returnVal.append(s.charAt(i));
            }
        }

        return returnVal.toString();
    };
}
