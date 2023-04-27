import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);       // Make this a field pretty much so can use it in multiple methods if needed
        int[] array = new int[5];

        for(int i = 0; i < array.length; i ++) {        // Probs make this a method
            System.out.println("Enter in value for element " + i);
            array[i] = scanner.nextInt();
        }

        printArray(array);

        int[] sortedArray = sortIntegers(array);

        printArray(sortedArray);
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i ++) {
            System.out.println("Element " + i + " inputted value: " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) { // passes in array
//        int[] sortedArray = new int[array.length];  // creates a new array the same length as the one passed in
//        for(int i = 0; i < array.length; i ++) {    // Makes a copy of the passed in array as the new variable in the method
//            sortedArray[i] = array[i];
//        }
//        Can copy this array an easier way.
        int[] sortedArray = Arrays.copyOf(array, array.length); // Copies array with the right length - if done 3. would only copy first 3 elements of array[]

        boolean flag = true;
        int temp;
        while(flag) {
            flag = false;   // because if it is descneded properly. will never go true again to retest
            for(int i = 0; i < sortedArray.length - 1; i ++ ) { // -1 becase in the line below it check 1 after.
                if(sortedArray[i] < sortedArray[i + 1]) {   // if one index after is better
                    temp = sortedArray[i];  // Make temp number so can be swapped without losing it
                    sortedArray[i] = sortedArray[i + 1];    // swap numbers
                    sortedArray[i + 1] = temp;  // make one after the temp number to finish swap
                    flag = true;    // true again to retest
                }
            }
        }

        return sortedArray;
    }
}
