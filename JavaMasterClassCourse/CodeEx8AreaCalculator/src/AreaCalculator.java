public class AreaCalculator {

    public static double area(double radius) {  // Return area of a circle
        return (radius < 0) ? -1 : (radius * radius) * Math.PI;
    }

    public static double area(double x, double y) { // Return area of rectangle
        return ((x < 0) || y < 0) ? -1 : x * y;
    }
}
