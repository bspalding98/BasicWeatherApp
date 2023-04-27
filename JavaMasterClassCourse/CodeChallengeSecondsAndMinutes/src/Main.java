public class Main {

    public static void main(String[] args) {
        System.out.println(getDurationString(118, 59));

        System.out.println(getDurationString(7139));
    }


    public static String getDurationString(int minutes, int seconds) {
//        return (minutes >= 0 && seconds >= 0 && seconds <= 59) ? (minutes / 60) + "h " +
//                (minutes % 60) + "m " + seconds + "s" : "Invalid value";

        if ((minutes < 0) || (seconds < 0) || (seconds >59)) {
            return "Invalid value";
        }

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

        String hoursString = hours + "h";
        if (hours < 10) {
            hoursString = "0" + hoursString;
        }

        String minutesString = remainingMinutes + "m";
        if (remainingMinutes < 10) {
            minutesString = "0" + minutesString;
        }


        String secondsString = seconds + "m";
        if (remainingMinutes < 10) {
            secondsString = "0" + secondsString;
        }

        return hoursString + " " + minutesString + " " + secondsString;


//        Can still use ternary operators and just keep adding a result string
//        Or could have another method for the if control statements as it's duplicated.
    }


    public static String getDurationString(int seconds) {
        int minutes = seconds / 60;
        int newSeconds = seconds % 60;

        return seconds >= 0 ? getDurationString(minutes, newSeconds) : "Invalid value";
    }
}
