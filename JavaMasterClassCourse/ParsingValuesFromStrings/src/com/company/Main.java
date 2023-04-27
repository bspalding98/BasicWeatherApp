package com.company;

public class Main {

    public static void main(String[] args) {

        String numberAsString = "2018.125";
        System.out.println("numberAsString = " + numberAsString);

        double number = Double.parseDouble(numberAsString);
        System.out.println("Number = " + number);

        numberAsString += 1;        // = 20181 - Java automatically realises and converts 1 into a string and concatenates (appends) it.
        number += 1;                // = 2019

        System.out.println("NumberAsString = " + numberAsString);
        System.out.println("Number = " + number);



    }
}
