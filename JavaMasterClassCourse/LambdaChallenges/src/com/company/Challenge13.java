package com.company;

import java.util.Arrays;
import java.util.List;

/**
 * Let's go back to the previous version of the code, when we were printing out the sort names. Let's suppose we want to
 * debug what's going on when the chain is executed.
 *
 * Instead of printing out the names at the end of the chain, maybe we're not sure if the code that uppercases
 * the first letter is working correctly.
 *
 * Let's use peek() to print out the names after the map() method has executed. What will the following code print
 * to the console.
 */

public class Challenge13 {

    public static void main(String[] args) {
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        // Answer
        // It won't print anything because there is no terminal operation and stream is evaluated lazily so needs one for the to be executed
//        topNames2015.stream()
//                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
//                .peek(System.out::println)
//                .sorted(String::compareTo);

    }
}
