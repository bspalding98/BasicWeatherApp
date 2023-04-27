package com.company;

import java.util.function.Supplier;

/**
 * Now write a lambda expression that maps to the java.util.Supplier interface.
 * This lambda should return the string "I love Java!" Assign it to a variable
 * called iLoveJava.
 */

// Supplier produces objects, doesn't accept any arguments
    // since single statement, don't need to include return because it's implied

public class Challenge6 {

//    Supplier<String> iLoveJava = new Supplier<String>() {
//        @Override
//        public String get() {
//            return "I love Java!";
//        }
//    };

    //Answer
//    Supplier<String> iLoveJava = () -> "I love Java!";

    //Include return statement if wanted
    Supplier<String> iLoveJava = () -> { return "I love Java!"; };
}
