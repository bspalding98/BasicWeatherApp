package com.company;

// Lambdas
// Only way to be used
// provide us an easier way to work with interfaces that only have one method
    // Normally used with anonymous classes
// also referred to as functional interfaces

// lambda expressions have three parts:
    // 1: argument list
    // 2: arrow token
    // 3: the body

// once you implement Comparable then you will sort your items by the condition in compare method.
// But if you want to sort them differently then you will need comparator. Usually it is better practice to create multiple singleton comparators and just reuse them.
// For example lets say you have class Person with fields firstName and lastName. If you implement Comparable
// and sort by first name then you can only sort by first name. But if you create multiple comparators then you can
// choose which comparator do you want to use. For example Comparator that sorts by lastName or comparator that sorts by both first and last name.


// comparator has an equals()
// all objects has a default equals()
// Therefore the comparator only has a single() that has to be implemented by classes that implement it

// ForEach() takes a lambda expression and evaluates it for each item in the iterable collection

// LAMBDA expressions have
    //

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        new Thread(new CodeToRun()).start();

//        // Instead of class below could do this with anonymous class
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable");
//            }
//        }).start();
//
//        // USING LAMBDA EXPRESSION:
//        new Thread(() -> System.out.println("Printing from the Runnable")).start(); // single statement, cannot use ; after statement, only at end of line
//        // Printing several lines
//        new Thread(() -> {
//            System.out.println("Printing from the Runnable");
//            System.out.println("Line 2");
//            System.out.format("This is line %d\n", 3);
//        }).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Boyd Spalding", 23);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);


        // This can change the variable because the for each loop creates a local variable of each variable so it's essentially effectively final
        // for each is like this for loop below
        // creates a local variable everytime that will then update the variable outside making it effectively final???
        // So if we declare the employee outside and just reassigned it, wouldn't work
        // Employee employee;
//        for(int i=0; i<employees.size(); i++) {
//            Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

//        for(Employee employee : employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }

        // When iterating over a collection can user new iterator foreach()
        // FOREACH
        // means I think
        // For each employee's element which is an Employee employee print the lines
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

//        // sorting without lambda
//        // This is a functional interface so can be used for lambda expressions
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {    // -1, 0, 1 and moves it accordingly
                return employee1.getName().compareTo(employee2.getName());
            }
        });
//
//        // Using Lambda expression 1:
        Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
//
//        // Using Lambda expression 2:
//        Collections.sort(employees, Comparator.comparing(Employee::getName));
//
//        // Using Lambda expression 3:
//        employees.sort(Comparator.comparing(Employee::getName));
//
//
//
//        for(Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//
//        // BECAUSE INTERFACE ONLY HAS ONE METHOD and maybe coz doStringStuff only has 1 statment???
//        // Without lambda
////        String sillyString = doStringStuff(new UpperConcat() {
////            @Override
////            public String upperAndConcat(String s1, String s2) {
////                return s1.toUpperCase() + s2.toUpperCase();
////            }
////        },
////                employees.get(0).getName(), employees.get(1).getName());  // This part is a second parameter
//
//        // with lambda
////        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();   // concatenating the interface - BECAUSE WE STILL MUST DEFINE INTERFACE - assigned it to the variable
////        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName()); // concatenating method
//
//        // How to convert multiple things in the lambda
//        // RETURN statement is required if there are {} unless printing?
//        UpperConcat uc = (s1, s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s =  anotherClass.doSomething();
        System.out.println(s);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }

}

class Employee {    // Can also put comparable method in here instead
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class CodeToRun implements Runnable{
    @Override
    public void run() {
        System.out.println("Printing from the Runnable");
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        // Can change the value of variables declared inside the scope of the lambda expression (local variable to the lambda)

//        Could not use this inside the anonymous class unless final
        // Another reason to be final is because if the Thread takes several seconds to execute the code, it will destroy the variable unless final???
        int i = 0;
//        i++;
        // With lambda
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is: " + getClass().getSimpleName());  // equals AnotherClass - lambda expression isn't a class, is treated
                    // like a nested block of code. Enclose in invisible {} pretty much
            // However, you cannot put a variable inside an anonymous block unless it is declared final or declared in the scope of the anonymous class
            // because local variable doesn't belong to the anonymous class instance - cannot update the anonymous class variable when it's updated outside of scope
            // However, you can use a local variable outside of the lambda expression scope because it is just treated as a nested block ONLY IF the value is never changed. if it is must be FINAL
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            // also cannot use variables made in here outside like s1 and s2, just the same as other blocks of code. Gets destroyed when goes back out unless returned
            return result;
        };

        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String 1", "String 2");


        // blank without lambda
//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName()); // name is blank because anonymous class doesn't have a name
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String 1", "String 2");
    }
}
