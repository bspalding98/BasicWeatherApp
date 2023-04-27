public class Car {
    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.engine = false;
        this.wheels = 4;
    }

    public String startEngine() {
//        return "Car -> engine is starting";
        return getClass().getSimpleName() + " -> startEngine()"; // getClass() returns class Car and getSimpleName() makes it return Car. and it works instead of overriding
    }

    public String accelerate() {
//        return "Car -> is accelerating";
        return getClass().getSimpleName() + " -> startEngine()";
    }

    public String brake() {
//        return "Car -> is braking";
        return getClass().getSimpleName() + " -> startEngine()";
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }
}
