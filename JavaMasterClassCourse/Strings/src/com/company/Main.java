package com.company;

public class Main {

    public static void main(String[] args) {
        // byte - almost never
        // short - almost never
        // int - common
        // long - rarely
        // float - almost never
        // double - common
        // char - rarely
        // boolean - common

        String myString = "This is a string";
        System.out.println("MyString is equal to " + myString);
        myString = myString + ", and this is more";
        System.out.println("MyString is equal to " + myString);
        myString = myString + " \u00A9 2019";
        System.out.println("myString is equal to " + myString);
        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println(numberString);

        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("lastString is equal to " + lastString);

        double doubleNumber = 120.47d;
        lastString += doubleNumber;
        System.out.println("lastString is equal to " + lastString);

    }
}
