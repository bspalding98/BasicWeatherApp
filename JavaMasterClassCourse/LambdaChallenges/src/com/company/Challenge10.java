package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Change the code so that it uses method references. Remember that a method reference looks like Class::MethodName
 */

public class Challenge10 {

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

//        // Answer
//        topNames2015.stream()
//                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
//                .sorted()
//                .forEach(System.out::println);

        // Fixing Tim's solution
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUpperCaseList.forEach(s -> System.out.println(s));
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);


    }
}
