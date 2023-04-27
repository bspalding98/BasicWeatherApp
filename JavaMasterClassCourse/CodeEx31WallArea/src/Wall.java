public class Wall {
//    fields
    private double height;
    private double width;

//    Constructors
    public Wall() {
        this(0, 0);     // Do not need to even add this. Will auto generate 0 values. If had string would generate just "null" (default for string)
    }

    public Wall(double width, double height) {
        this.width = (width < 0) ? 0 : width;
        this.height = (height < 0) ? 0 : height;
    }

//    Setters
    public void setHeight(double height) {
        this.height = (height < 0) ? 0 : height;
    }

    public void setWidth(double width) {
        this.width = (width < 0) ? 0 : width;
    }

//    Getters
    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getArea() {
        return height * width;
    }
}
