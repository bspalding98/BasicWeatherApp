package com.company;

import java.util.function.Supplier;

/**
 * As with Function, the Supplier won't do anything until we use it. Use this supplier to assign the string "I love Java!"
 * to a variable called supplierResult. Then print the variable to the console.
 */

public class Challenge7 {

    public static void main(String[] args) {

        Supplier<String> iLoveJava = () -> "I love Java!";

        //Answer
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }
}
