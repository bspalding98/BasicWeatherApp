public class Car extends Vehicle{

    private int doors;
    private int gears;
    private int wheels;
    private int currentGear;
    private boolean isManual;



    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.changeGear(): Changed to " + this.currentGear + " gear");
    }

    public void changeVelocity(int speed, int direction) {
        System.out.println("Car.changedVelocity(): Velocity " + speed + " direction " + direction);
        move(speed, direction);
    }
}
