public class Main {
    public static void main(String[] args) {
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.1756d, -3.175d));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.175d, 3.176d));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(3.0d, 3.0d));
        System.out.println(DecimalComparator.areEqualByThreeDecimalPlaces(-3.123d, 3.123d));
    }
}
