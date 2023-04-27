package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i = 1; i <= 100; i ++) {
            squares.add(i * i); //i^2
            cubes.add(i * i * i);   //i^3
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes."); // Checking there are 100 values.

        // Instead of running a for loop and printing a chaotic order of the size of the unionised set. Printing the size is easier.
        // Bulk operations are destructive. Meaning they modify the Set that is called upon.
        // Hence why we made another instance. So this way we still have the Set squares, cubes and now also have the union Set.
        Set<Integer> union = new HashSet<>(squares);    // duplicate squares Set
        union.addAll(cubes);    // Did add all to union them.
        System.out.println("union contains " + union.size() + " elements"); // = 196.

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);  // only keeps the common elements
        System.out.println("intersection contains " + intersection.size() + " elements.");  // Should be 4 out of 200 as above the unique were 196 out of 200.
        for(int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));   // Showing what the square and cube numbers were for each one.
        }

        Set<String> words = new HashSet<>();
        String sentence = "One day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));    // Add all elements in the array as 1 set
        for(String s : words) {
            System.out.println(s);
        }

        // Asymmetric Set is to removeAll() - is asymmetric because s1 - s2 != s2 - s1 ( example is shown in the output of the code below)
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};  // Do it like this because in Java there are no Maps and Set literals like we have with array here. So this is the best way with .asList()
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine:");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("Divine = nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);


        // Symmetric difference has no method. But it is the elements that appear in 1 set or the other, but not both.
        // Defined as union - intersections.
        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference:");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        // containsALl - used to test if 1 set is a superset of the other.
        // Not destructive.
            // Only returns like true or false depending on your answer, Does no modify the sets.
        if(nature.containsAll(divine)) System.out.println("divine is a subset of nature");
        if(nature.containsAll(intersectionTest)) System.out.println("intersection is a subset of nature");
        if(divine.containsAll(intersectionTest)) System.out.println("intersection is a subset of divine.");

    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for(String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
