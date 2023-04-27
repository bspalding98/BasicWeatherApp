import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int counter = 0;
//        long average = 0;

//        while(true) {
//            boolean isAnInteger = scanner.hasNextInt();
//
//            if(isAnInteger) {
//                counter ++;
//                int number = scanner.nextInt();
//                sum += number;
//            } else {
//                average = Math.round((double) sum / counter);
//                System.out.println("SUM = " + sum + " AVG = " + average);
//                break;
//            }
//        }

        while(scanner.hasNextInt()) {
            sum += scanner.nextInt();
            counter ++;
        }
        System.out.println("SUM = " + sum + " AVG = " + Math.round((double) sum / counter));
        scanner.close();
    }
}
