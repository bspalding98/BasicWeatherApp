package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Value makes a copy directly and then both variables work independently.
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        anotherIntValue ++;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);


        // Reference types different. You use new keyword to create an instance. object holds a reference or address to an array in memory

        int[] myIntArray = new int[5];  // Reference to the array in memory.
        int[] anotherIntArray = myIntArray; // Another reference to the same memory. both hold the same address as there is no new so make a new reference

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));  // Every element is separated by a comma using this method from the Arrays class.
        System.out.println("anotherIntArray = " + Arrays.toString(anotherIntArray));

        // Prints the same output because they both represent the same array in memory.
        System.out.println("anotherIntArray memory address = " + anotherIntArray); // Prints the address to the memory
        System.out.println("anotherIntArray memory address = " + myIntArray); // Prints the address to the memory

        anotherIntArray[0] = 1; // When one is updated, the memory is updated. So if there is several references to the memory. They all get updated.
        // Both variables are being changed as they are both referencing the same array in memory
        System.out.println("After change, myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("After change, anotherIntArray = " + Arrays.toString(anotherIntArray));

//        anotherIntArray = new int[] {4, 5, 6, 7, 8};  // This line of code creates a new memory so they both are not changed from method below where it originally was.
        modifyArray(myIntArray);

        System.out.println("After change, myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("After change, anotherIntArray = " + Arrays.toString(anotherIntArray));
    }

    private static void modifyArray(int[] array) {

        array[0] = 2;
        array = new int[] {1, 2, 3, 4, 5};      // Points to new array memory now so can not be referenced as why it is greyed out. Has been dereference
    }
}
