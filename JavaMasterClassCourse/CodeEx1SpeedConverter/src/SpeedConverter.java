public class SpeedConverter {


    public static long toMilesPerHour(double kilometersPerHour) {

        if (kilometersPerHour < 0) {
            return -1;
        }

        return Math.round(kilometersPerHour / 1.609d);
    }


    public static void printConversion(double kilometersPerHour) {

        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
        }
    }


//    THIS IS A MORE EFFICIENT WITH TERNARY OPERATOR


//    public static long toMilesPerHour(double kilometersPerHour) {
//
//        return kilometersPerHour < 0 ? -1 : Math.round(kilometersPerHour / 1.609);
//    }
//
//
//    public static void printConversion(double kilometersPerHour) {
//
//        System.out.println(kilometersPerHour < 0 ? "Invalid Value" : kilometersPerHour + " km/h = " +
//                toMilesPerHour(kilometersPerHour) + " mi/h");
//    }
}
