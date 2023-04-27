public class DiagonalStar {

    public static void printSquareStar(int number) {

        if(number < 5) {
            System.out.println("Invalid Value");
        } else {
//            for(int i = 1; i <= number; i ++) {
//
//                if((i == 1) || i == number) {
//                    for (int j = 1; j <= number; j++) {
//                        System.out.print("*");
//                    }
//                } else {
//                    for(int k = 1; k <= number; k ++) {
//                        if(k == 1 || k == number || k == i || k == ((number - i) + 1)) {
//                            System.out.print("*");
//                        }else {
//                            System.out.print(" ");
//                        }
//                    }
//                }

            for(int i = 1; i <= number; i ++) {         // Runs each row
                for(int k = 1; k <= number; k ++) {
                    if (k == 1 || k == number || k == i || k == ((number - i) + 1) || (i == 1) || (i == number)) {      // Runs each column
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
//                Just merged the two together because I can still access "i" inside the next for loop as it is inside the scope.

                System.out.println();
            }
        }
    }
}
