package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// stream
// sequence of computations
    // computational steps chained together


// ForEach takes a consumer
    // used with iterating over a collection
    // is a lambda

// Stream is a set of object references
    // Creates a stream from the reference

// using streams need two requirements:
    // 1. Non interfering
        // Don't change the stream source in anyway
    // 2. must be stateless
        // can't depend on any state outside the operation - can't depend on variable values in a previous step
// Should be seen as an independent step that's operating on a stream argument

// enters the pipeline and exits at the bottom with everything done to it
// Can also be created from scratch
    // stream.of
// cannot create a stream of mixed types - but if only the one type, can be any type


// terminal operations
    // returns either void or returns a non stream result
// Intermediate operations
    // return a stream - don't force the end of the chain


// REMEMBER Stream can only be operated on once

// FlatMap() to map a single object to more than one object
// called flatmap because it's often used to flatten nested lists

// collect() stores the stream into a another collection
// Can change .collect() to make it so you can collect as specific types like array lists etc.
// can use groupby() to group the list by age or something if wanted
    // .collect(Collectors.groupingBy(employee -> employee.getAge()));
// Also has reduce()


// cannot reuse streams once used a terminal operation - illegalstateexception
    // intermediate operation not performed until terminal operation is created - lazily evaluated
    // THIS MAKES SENSE because why should it evaluate anything if nothing is coming out of the pipe
// can use specific streams with additional methods - eg, intStream, etc.

// parallel streams, out of the course


public class Main {

    public static void main(String[] args) {
	    var someBingoNumbers = Arrays.asList(
	            "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71"
        );

        List<String> gNumbers = new ArrayList<>();   // effectively final so can use in lambda


        // Now we can replace all the stuff below with one line using streams
        // ------------ All below return a stream, so it slowly gets cut down or altered -----------------
        // Stream below essentially means it's a stream that contains all the item in the someBingoNumber in the order of the collection
        // next is map() accept a function to apply to the elements of the stream. not a Bifunction
        // next is filter() returns a stream consisting of elements of this stream that match the given predicate
        // next is sorted() sorts the elements accords to natural order
        // Next is forEach()
            // These are all from the stream class

        // Remember the comparator is comparing strings, so if use "B", it would not print in the correct order
            // Since comparing string not a number type, it looks at B1, which is before B6
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)   // method reference - use them when all a lambda does is call an existing method - could have been using them all along
//                .map(s->s.toUpperCase())    // This was the old way
                .filter(s->s.startsWith("G"))   // cannot use method reference here because there is no way for the compiler to know that the argument should be G
                .sorted()
                .forEach(System.out::println);  // ends here because nothing to pass on since forEach doesn't return a value (terminal operation)

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        // concat them together
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);    // static so cannot use in chain but the source for a chain
//        System.out.println(concatStream.count());   // count() returns a long value, so it's a terminal operation
        // remove duplicate numbers
//        System.out.println(concatStream.distinct().count());    // distinct() removes duplicate suing string.equals in it pretty sure

        // printing out items in stream without ending chain
            // cannot use forEach as it's terminal, will end stream
        // so use peek - accept consumer argument, evaluates it as a new stream and returns a stream value, it's intermediate
        System.out.println("----------------------------------");
        System.out.println(concatStream
//                .peek(System.out::println)
                .distinct()
                .peek(System.out::println)
                .count());




////         this is the old basic code
//	    someBingoNumbers.forEach(number -> {
//	        if(number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
////	            System.out.println(number);
//            }
//        });
//
////	    gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));  // This can be either of the two below
////	    gNumbers.sort(String::compareTo);
//	    gNumbers.sort(Comparator.naturalOrder());
//
//	    gNumbers.forEach(System.out::println);






        // flatmap

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        // print all employees from the company
            // could add a method in department class to print. but going to use flatmap() isntead
        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())  // wants a function that returns a stream
                .forEach(System.out::println);

        // Using collect
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                // first arg is the supplier - 2nd arg is accumulator, 3rd arg is the combiner
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//                .collect(Collectors.toList());  // List we can continue to work with if we wanted to    - Hence letting the loop happen below?

        sortedGNumbers.forEach(System.out::println);

//        // groupingby
//        Map<Integer, List<Employee>> groupedByAge = departments.stream()
//                .flatMap(department -> department.getEmployees().stream())
//                .collect(Collectors.groupingBy(employee -> employee.getAge()));
//
//        // reduce - this is based off if age is less than or not - result will be the youngest employee - reduce is terminal so need to print
//        departments.stream()
//                .flatMap(department -> department.getEmployees().stream())
//                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
//                .ifPresent(System.out::println);



        // lazily evaluated example:
        // This below doesn't get evaluated because there is no terminal operation.
//        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
//                .filter(s -> {
//                    System.out.println(s);
//                    return s.length() == 3;
//                });

        //FIX
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();





    }
}
