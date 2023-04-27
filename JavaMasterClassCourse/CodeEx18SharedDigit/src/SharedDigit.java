public class SharedDigit {

    public static boolean hasSharedDigit(int num1, int num2) {

        if(num1 < 10 || num1 > 99 || num2 < 10 || num2 > 99) {
            return false;
        }
//              STUPID: was comparing digits in same number when did not have to
//        int temp1 = num1 % 10;
//        int temp2 = num1 / 10;
//        int temp3 = num2 % 10;
//        int temp4 = num2 /10;
//
//        return temp1 == temp2 || temp1 == temp3 || temp1 == temp4 || temp2 == temp3 || temp2 == temp4 ||
//                temp3 == temp4;

        return ((num1 / 10 == num2 / 10) || (num1 / 10 == num2 % 10) || (num1 % 10 == num2 % 10) || num1 % 10 == num2 / 10);

    }
}
