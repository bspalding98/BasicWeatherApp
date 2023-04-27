public class NumberToWords {

    public static void numberToWords(int number) {

        if(number < 0) System.out.println("Invalid Value");

        int numberChecker = getDigitCount(number);
        int reversedNumber = reverse(number);
//        int zeroDigitCount = 0;

        String word = "";
        for(int i = 0; i < numberChecker; i ++) {
            switch(reversedNumber % 10) {
                case 0: word += "Zero "; break;
                case 1: word += "One "; break;
                case 2: word += "Two "; break;
                case 3: word += "Three "; break;
                case 4: word += "Four "; break;
                case 5: word += "Five "; break;
                case 6: word += "Six "; break;
                case 7: word += "Seven "; break;
                case 8: word += "Eight "; break;
                case 9: word += "Nine "; break;
            }
            reversedNumber /= 10;
//            zeroDigitCount = numberChecker - i;       // Would run this if did not have loop to include 0 (read comment line below)
        }

        System.out.println(word);

//        Think they wanted us to run that for the numbers above and then have a separate bit of code to check for 0
//
//            for( int i = 0; i < zeroDigitCount; i++) {
//                word += "Zero ";
//            }
    }


    public static int reverse(int number) {

        int reverse = 0;
        while(number != 0) {
            reverse = (reverse * 10) + (number % 10);
            number /= 10;
        }

        return reverse;
    }

    public static int getDigitCount(int number) {
        if(number < 0 ) return -1;

        int count = 1;
        while(number > 9) {
            count ++;
            number /= 10;
        }

        return count;
    }
}
