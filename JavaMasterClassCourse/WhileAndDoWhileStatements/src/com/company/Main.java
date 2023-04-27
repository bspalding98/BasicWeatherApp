package com.company;

public class Main {

    public static void main(String[] args) {
//        int count = 0;
//        while(count != 5) {
//            System.out.println("Count value is " + count);
//            count ++;
//        }

//        Equivalent to above in for loop
//        for (count = 1; count < 5; count ++) {
//            System.out.println("Count value is " + count);
//        }

//        count = 0;
//        while(true) {
//            if(count == 5) {
//                break;
//            }
//            System.out.println("Count value is " + count);
//            count ++;
//        }

//        do {
//            System.out.println("Count value was " + count);
//            count ++;
//        } while (count != 5);
//        DO while is guaranteed to execute once. So if intial value was alreayd 5. In this code block above it would
//        be an infinite loop as it will run once intially and then count++ will make count = 6 so it will never now
//        equal 5 so will forever run.
//        FIX that above

//        do {
//            System.out.println("Count value was " + count);
//            count ++;
//        } while (count < 5);



//        CHALLENGE
        int number = 4;
        int finishNumber = 20;
        int evenNumber = 0;
        int evenNumberTotal = 0;

        while(number <= finishNumber) {
            number ++;                                          // NORMALLY INCREMENT first or can end up in infinite loop but just dependant
            if(isEvenNumber(number)) {
                evenNumber ++;
                evenNumberTotal += number;
                System.out.println(number);     // Could check for !isEvenNumber(number) and then continue if so and put this statement below
                if(evenNumber == 5) {
                    System.out.println(evenNumber);
                    System.out.println(evenNumberTotal);        // Having the if statement inside the other is better because if it is outside it will run even if it's an odd number.
                    break;
                }
            }
        }
    }

//    CHALLENGE
    public static boolean isEvenNumber(int num) {
        return (num % 2) == 0;
    }
}
