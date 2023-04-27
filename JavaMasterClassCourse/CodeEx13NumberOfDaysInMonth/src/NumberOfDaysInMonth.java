public class NumberOfDaysInMonth {

    public static boolean isLeapYear(int year) {

        return (((year % 4 == 0 && year % 100 != 0) || (year % 400 ==0)) && (year >=1 && year <=9999));
    }

    public static int getDaysInMonth(int month, int year) {

//        return ((month < 1) || (month > 12) || (year < 1) || (year > 9999) ? -1 :
//                month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12 ? 31 :
//                        month == 4 || month == 6 || month == 9 || month == 11 ? 30 :
//                                isLeapYear(year) ? 29 : 28);


        
//        USING A SWITCH STATEMENT

        if (((month < 1) || (month > 12)) || ((year < 1) || (year > 9999))) {
            return -1;
        }

        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                    return 31;
        }
    }
}
