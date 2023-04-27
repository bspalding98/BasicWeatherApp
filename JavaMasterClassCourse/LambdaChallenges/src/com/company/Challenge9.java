package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Suppose we have the following list of the top 5 males and females names for 2015:
 *
 * Write code to print the items in the list in sorted order, and with the first letter in each
 * name upper-cased. The name "harry" should be printed as "Harry" and should be printed
 * after "Emily" and before "Isla". Use lambda expression wherever possible.
 *
 */

public class Challenge9 {

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

        // HOw Tim did it
//        List<String> firstUpperCaseList = new ArrayList<>();
//        topNames2015.forEach(name ->
//                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUpperCaseList.forEach(s -> System.out.println(s));

    }
}
