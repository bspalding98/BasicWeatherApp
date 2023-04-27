package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.*;

// The above responses were clear, but if there is still any confusion, running the code below was helpful to understanding how chaining Consumers works.
//
//    Consumer<String> c1 = s -> System.out.println(s.toUpperCase());
//    Consumer<String> c2 = s -> System.out.println(s);
//
//    c1.andThen(c2).accept("Hello World!");
//Console output:
//
//HELLO WORLD!
//Hello World!
//Because Consumers don't return a value, both c1 and c2 operate on the same argument (in this case, the string "Hello World!").
// So when c1 executes, it prints the uppercase version of the input (HELLO WORLD!). When c2 executes,
// it just prints out the argument unchanged (Hello World!) since it operates on the original argument.

// functional package - to see other functional interfaces built in
// forEach cannot return anything because with the lambda put it uses consumer and that does not return anything

// Predicate argument are just lambda expressions that match the predicate interface
// Predicate uses test() to return a boolean which can be used for loops like seen below
    // the predicate accepts one parameter and returns a boolean value

// lambda is just tidier and quicker coding sort
// everything can still be done with an anonymous class

// consumer and predicate user generic and don't care about type passed in
    //double, int, and long consumer and predicate - which needs lambda of those types
// WHERE POSSIBLE you should use the specific types of lambda for better readability

// So consumer doesn't return anything. it just prints I think, may assigns? only takes one parameter and has only one method accept()
    // Not sure if that is right

// Can reuse predicates and also chain them
    // These interfaces contain and, or, and negate. some also isequals

// Supplier always returns a value
// Can pass in methods like Predicate below - can use when testing a app, etc.
// a boolean, double, int and double supplier

// Function doesn't require the need to create a class like for anonymous classes or no need for a old regular method,
    // but you can pass code that accepts and returns a value through a lambda without having to create and interface and a class that
    // implements the interface
// Can use when there is like 30 lines of code that are similar?

// EG
    // Had a program that wanted to resize images different based off algorithms
    // Instead of writing a class for each of them and an interface, you could just write functions for each algorithm?

// Functions also hav intToDouble where it takes and int and returns a double
    // There are several
// Also, you can chain them together
    // use addThen()
    // Return value of each function is operated in the chain

// Bi interface and Uniary interface -  down below


public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee boyd = new Employee("Boyd Spalding", 23);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red RidingHood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(boyd);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        //        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);    // substring after first space to lastName
//            System.out.println("Last Name is: " + lastName);
//        });
        // If we want to get the lastName is several places in the class
        // Use a lambda function interface
        // REUSING LASTNAME:

//        // Setting up function interface
//        Function<Employee, String> getLastName = (Employee employee) -> {   // 1st type is argument type and 2nd type is the return type - also always need curly braces even if one statement
//            return employee.getName().substring(employee.getName().indexOf(' ')+ 1);
//        };
//
//        String lastName = getLastName.apply(employees.get(1));
//        System.out.println(lastName);
//
//        Function<Employee, String> getFirstName = (Employee employee) -> {
//            return employee.getName().substring(0, employee.getName().indexOf(' '));
//        };
//        String firstName = getFirstName.apply(employees.get(1));
//        System.out.println(firstName);
//
//        Random random1 = new Random();
//        for(Employee employee : employees) {
//            if(random1.nextBoolean()) {
//                System.out.println(getAName(getFirstName, employee));
//            } else {
//                System.out.println(getAName(getLastName, employee));
//            }
//        }


        // Chaining
        // get first name upperBased
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        Function<Employee, String> chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        // Bi interface
        // cannot change this function to upperCase because of andThen, result of one function become the argument for another
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };
        // However, can do this, just split them pretty much
        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));
        // Consumer and predicate interfaces except two arguments - not supplier because it doesn't except any arguments

        // UnaryFunction - single argument and returns the same value - EG, long to long - extend form function so can be chained together
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));


        //chaining consumer
        // c1 is lost because it doesn't return anything.
//        Consumer<String> c1 = s -> s.toUpperCase();
//        Consumer<String> c2 = s -> System.out.println(s);
        //Using method reference
        Consumer<String> c1 = String::toUpperCase;
        Consumer<String> c2 = System.out::println;
        c1.andThen(c2).accept("Hello World");


//        // USING METHOD BELOW FOR COMBINE FOR LOOP - using lambda for predicate
//        printEmployeesByAge(employees, "Employees over 30:", employee -> employee.getAge() > 30);
//            // employee -> employee.getAge() > 30. This means we are testing employee and testing the starting after ->
//        printEmployeesByAge(employees, "Employees 30 and under:", employee -> employee.getAge() <= 30);
//
//        // Using anonymous class instead of lambda above
//        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
//            @Override
//            public boolean test(Employee employee) {
//                return employee.getAge() < 25;
//            }
//        });
//
//
//        // This is what is looks like without lambda
////        IntPredicate inta = new IntPredicate() {
////            @Override
////            public boolean test(int i) {
////                return i > 15;
////            }
////        };
//        // REUSING PREDICATES
//        IntPredicate greaterThan15 = i -> i > 15;
//        // call the method the lambda is mapped to which is test in this case
//        System.out.println(greaterThan15.test(10));  // Prints false
//        int a = 20;
//        System.out.println(greaterThan15.test(a + 5));   // Prints true
//
//        IntPredicate lessThan100 = i -> i < 100;
//        // CHAIN PREDICATES TOGETHER
//        System.out.println(greaterThan15.and(lessThan100).test(50));
//        System.out.println(greaterThan15.and(lessThan100).test(15));
//
//        Random random = new Random();
//        for(int i = 0; i < 10; i++) {
//            System.out.println(random.nextInt(23));
//        }
//
//        // using a supplier - it always returns a value
//        Supplier<Integer> randomSupplier = () -> random.nextInt(23);    // Can pass in methods like Predicate below - can use when testing a app, etc.
//        // a boolean, double, int and double supplier
//        for(int i = 0; i < 10; i++) {
//            System.out.println(randomSupplier.get());
//        }
////        Supplier<Integer> randoms = new Supplier<Integer>() {
////            @Override
////            public Integer get() {
////                return random.nextInt(23);
////            }
////        }




        // Could merge above by just creating a method that passes in a boolean on whether to be > or <=
        // Better way:
        // Predicate interface - built into the java.util.function package
        // test() is the functional method
        // this use is seen the in method create below

//        System.out.println("Employees over 30");
//        System.out.println("=================");
//        //lambda
//        employees.forEach(employee -> {
//            if(employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });
//
//        System.out.println("\nEmployees 30 and younger");
//        System.out.println("===========================");
//        employees.forEach(employee -> {
//            if(employee.getAge() <= 30)
//                System.out.println(employee.getName());
//        });
    }

    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee); // Should return an employee object
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        // cannot use forEach here because it expects a Consumer - This is like the same I think.
        System.out.println(ageText);
        System.out.println("=================");
        for(Employee employee : employees) {
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
