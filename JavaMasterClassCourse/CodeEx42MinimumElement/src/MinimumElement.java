import java.util.Scanner;

public class MinimumElement {



        private static int readInteger() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter amount of numbers wanting to be entered");
            int amount = scanner.nextInt();
            scanner.nextLine();

            return amount;
        }

        private static int[] readElements(int count) {
            Scanner scanner = new Scanner(System.in);
            int[] array = new int[count];

            for(int i = 0; i < count; i ++) {
                System.out.println("Please enter in element number " + i + ":");
                array[i] =  scanner.nextInt();
                scanner.nextLine(); // Catches enter key after input above so it doesn't enter as soon as you input next number and then break it. However in this instance it would not anyways
            }

            return array;
        }

        private static int findMin(int[] array) {
            int min = Integer.MAX_VALUE;


            for(int i = 0; i < array.length; i ++) {
                min = Math.min(array[i], min);
            }

            return min;
        }
}


