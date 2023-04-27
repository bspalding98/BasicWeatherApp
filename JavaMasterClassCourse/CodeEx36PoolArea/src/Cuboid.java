public class Cuboid extends Rectangle {
//    fields or instance variables or member variables
    private double height;

//    constructors and setters
    public Cuboid(double width, double length, double height) {
        super(width, length);
        this.height = (height < 0) ? 0 : height;
    }

//    getters
    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return (getArea() * height);
    }
}
