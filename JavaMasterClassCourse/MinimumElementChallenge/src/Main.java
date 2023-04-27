import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter amount of numbers wanting to be entered");
        int count = scanner.nextInt();
        scanner.nextLine();

        int[] array = readIntegers(count);

        int min = findMin(array);
        System.out.println("Minimum Number in array: " + min);


    }

    public static int[] readIntegers(int count) {
        int[] array = new int[count];

        for(int i = 0; i < count; i ++) {
            System.out.println("Please enter in element number " + i + ":");
            array[i] =  scanner.nextInt();
            scanner.nextLine(); // Catches enter key after input above so it doesn't enter as soon as you input next number and then break it. However in this instance it would not anyways
        }

        return array;
    }

    public static int findMin(int[] array) {
//        int min = 0;
//
//
//        for(int i = 0; i < array.length; i ++) {
//            min = (min == 0) || (array[i] < min) ? array[i] : min;  // Could just make min = Integer.MAX_VALUE above so would not need min==0
//        }

        int min = Integer.MAX_VALUE;


        for(int i = 0; i < array.length; i ++) {
            min = Math.min(array[i], min);
        }

        return min;
    }
}
