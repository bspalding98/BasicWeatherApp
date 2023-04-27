public class MinutesToYearsDaysCalculator {

    private static final long MINUTES_IN_YEARS = (60 * 24 * 365);

    public static void printYearsAndDays(long minutes) {
        long years = minutes / MINUTES_IN_YEARS;
        long remainingMinutes = (minutes % MINUTES_IN_YEARS) / (60 * 24);

        System.out.println((minutes < 0) ? "Invalid Value" : minutes + " min = " + years + " y and " + remainingMinutes
                + " d");
    }
}
