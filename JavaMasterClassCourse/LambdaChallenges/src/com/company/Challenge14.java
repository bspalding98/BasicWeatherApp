package com.company;

import java.util.Arrays;
import java.util.List;

/**
 * Add a terminal operation to this chain so that the peek call will execute
 *
 * Since the peek() call is printing every item, try to do something else with the termainl operation.
 * Don't print out the items again.
 */

public class Challenge14 {

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
                .peek(System.out::println)
                .sorted(String::compareTo)
                .reduce((s1, s2) -> s1.length() < s2.length() ? s1 : s2)
                .ifPresent(System.out::println);
    }
}
