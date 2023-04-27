package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

////        int [] myIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Can only do this when first defining it? Not later on
//        int [] myIntArray = new int[15];
////        myIntArray[0] = 45;
////        myIntArray[1] = 476;
////        myIntArray[5] = 50;
////        Instead can do this if know values (line 7) or this below
//        for(int i = 0; i < myIntArray.length; i ++) {       // myIntArray.length is the length of the array ie the index length so this case would be 15
//                                                            // Good Idea to use over hard code due to readability and if you change array length.
//                                                            // it will auto change here. Also stops error if hardcode length is set too long.
//            myIntArray[i] = i * 10;
//        }
//
//        printArray(myIntArray);
//    }
//
//    public static void printArray(int[] array) {
//        for(int i = 0; i < array.length; i ++) {
//            System.out.println("Element " + i + ", value is " + array[i]);
//        }



//        Real life use


        int[] myIntegers = getIntegers(5);  // Get an input with that will assign to arrays

        for(int i = 0; i < myIntegers.length; i ++) {   // List each element of the array and the inputted value
            System.out.println("Element " + i + ", typed value was " + myIntegers[i]);
        }

        System.out.println("The average is " + getAverage(myIntegers)); // Print the average of the array

    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.");
        int [] values = new int[number];

        for(int i = 0; i < values.length; i ++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static double getAverage(int[] array) {
        double sum = 0;
        for(int i = 0; i < array.length; i ++) {
            sum += array[i];
        }

        return sum / array.length;
    }


}
