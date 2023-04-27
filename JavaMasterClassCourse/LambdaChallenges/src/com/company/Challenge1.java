package com.company;

import java.util.Arrays;

/**
 * Change the commented out code into a lambda expression
 */

public class Challenge1 {
    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                String myString = "Let's split this up into an array";
//                String[] parts = myString.split(" ");
//                for (String part : parts) {
//                    System.out.println(part);
//                }
//            }
//        };

        //Answer
        // uses no interface
        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };


        // Using streams to concise it for practice
        new Thread(() ->
                Arrays.stream("Let's split this up into an array".split(" "))
                        .forEach(System.out::println)).start();
    }
}
