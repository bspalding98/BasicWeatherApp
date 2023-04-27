package com.company;

public class Main {

    public static void main(String[] args) {

//        int value = 3;
//        if (value == 1) {
//            System.out.println("Value was 1");
//        } else if (value ==2) {
//            System.out.println("Value was 2");
//        } else {
//            System.out.println("Was not 1 or 2");
//        }

        int switchValue = 2;
        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                break;

            case 2:
                System.out.println("Value was 2");
                break;

            case 3: case 4: case 5:
                System.out.println("Value was a 3, or a 4, or a 5");
                System.out.println("Actually it was a " + switchValue);
                break;

            default:
                System.out.println("Value was not 1 or 2");
//                break;    Is not needed as it's the end of the switch statement code block
//                However good to keep it in for practice and consistency. ALWAYS ADD BREAKS
        }

        // Where break would come down to
//        NO break means it will run next lines of code regardless if true or not until there is another break

//        ONly can be used with int, char, byte, short.


//        CHALLENGE:

        char character = 'A';
        switch (character) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.println("You found char " + character);
                break;
            default:
                System.out.println("Sorry nothing was found");
        }


//        System.out.println(character == 'A' || character == 'B' || character == 'C' || character == 'D' ||
//                character == 'E' ? "You found char " + character : "Sorry nothing was found");

        String month = "JanuarY";
        switch (month.toLowerCase()) {
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
        }

    }
}
