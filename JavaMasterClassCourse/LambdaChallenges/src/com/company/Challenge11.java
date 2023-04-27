package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Now do the same thing (uppercase first letter, then sort and print the list) using a stream and a chain of stream operations.
 */

public class Challenge11 {

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
        topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .sorted()
                .forEach(System.out::println);
    }
}
