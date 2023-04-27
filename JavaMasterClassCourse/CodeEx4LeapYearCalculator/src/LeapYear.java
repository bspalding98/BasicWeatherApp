public class LeapYear {

    public static boolean isLeapYear(int year) {
        return ((year >= 1 && year <= 9999) && (year % 4 == 0 && year % 100 == 0 && year % 400 == 0)) ||
                ((year >= 1 && year <= 9999) && (year % 4 == 0 && year % 100 != 0));
    }

//    OR - Found this better code and  it's better

//    public static boolean isLeapYear(int year) {
//        return (((year % 4 == 0 && year % 100 != 0) || (year % 400 ==0)) && (year >=1 && year <=9999));
//    }
}
