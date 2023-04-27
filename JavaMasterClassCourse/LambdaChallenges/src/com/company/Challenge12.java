package com.company;

import java.util.Arrays;
import java.util.List;

/**
 * Instead of printing out the sorted names, print out how many names start with the letter 'A' instead
 */

public class Challenge12 {

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
        long namesBeginningWithA = topNames2015.stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .filter(name -> name.startsWith("A"))
                .count();
        System.out.println("Number of names beginning with A is: " + namesBeginningWithA);
    }
}
