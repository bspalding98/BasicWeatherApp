public class Point {
//    fields
    private int x;
    private int y;

//    Constructors
    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

//    Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    Methods
    public double distance() {
//        return Math.sqrt((getX()) * (getX()) + (getY()) * (getY()));        // did not do eg. (getX() - 0) because it just equals getx()
        return distance(0,0);   // This is good to do because it stop duplication of code and is essentially used like how the constructors are
    }

    public double distance(int x, int y) {
        return Math.sqrt((getX() - x) * (getX() - x) + (getY() - y) * (getY() - y));
    }

    public double distance(Point xy) {
        return Math.sqrt((getX() - xy.getX()) * (getX() - xy.getX()) + (getY() - xy.getY()) * (getY() - xy.getY()));
    }
}
