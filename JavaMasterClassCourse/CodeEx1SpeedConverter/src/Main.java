public class Main {

    public static void main(String[] args) {
        System.out.println(SpeedConverter.toMilesPerHour(1.5d));
        System.out.println(SpeedConverter.toMilesPerHour(10.25d));
        System.out.println(SpeedConverter.toMilesPerHour(-5.6d));
        System.out.println(SpeedConverter.toMilesPerHour(25.42d));
        System.out.println(SpeedConverter.toMilesPerHour(75.114d));

        SpeedConverter.printConversion(1.5d);
        SpeedConverter.printConversion(10.25d);
        SpeedConverter.printConversion(-5.6d);
        SpeedConverter.printConversion(25.42d);
        SpeedConverter.printConversion(75.114d);

    }


}
