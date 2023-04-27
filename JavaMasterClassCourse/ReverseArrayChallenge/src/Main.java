import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {2, 34, 25, 1, -1, 5};

        for(int i = 0; i < intArray.length; i ++) {
            System.out.println("Element " + i + " is " + intArray[i]);
        }

        reverse(intArray);

        System.out.println(Arrays.toString(intArray));

    }


    public static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;      // Do not need these, just helps readability if wanted

//        We could always make a copy of array[] and then just simple assign them in reverse with for loop. less code but challenge
//        was to complete without using another array.

        for(int i = 0; i < halfLength; i ++) {      // If do not make it half. It will swap last half which will then swap it back to original order
            int temp = array[i];
            array[i] = array[maxIndex - i];
            array[(array.length - 1) - i] = temp;
        }
    }
}
