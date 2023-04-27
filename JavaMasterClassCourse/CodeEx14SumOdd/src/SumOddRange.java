public class SumOddRange {

    public static boolean isOdd(int number) {
        return number >= 0 && (number % 2 != 0);

//        Need to remember that if it is just a boolean return true or false. Only need to check for true.
//        Because if return expression is not true, it is automatically returned as false.
    }


    public static int sumOdd(int start, int end) {
        if((end < start) || (start <= 0)) {
            return -1;
        }

        int sum = 0;
        for(int i = start; i <= end; i ++) {
            if(isOdd(i)) {
                sum += i;
            }
        }

        return sum;
    }
}
