public class Car extends Vehicle{   //IS A relation. "Car is a vehicle" Essentially what a inheritance is.
//    Composition: "HAS A" relationship
//    EG. Motherboard, case, and monitor of a pc (IS NOT) a PC but a PC (HAS A) mother, case, and monitor.
    private int doors;
    private int engineCapacity;

    public Car(String name, int doors, int engineCapacity) {
        super(name);
        this.doors = doors;
        this.engineCapacity = engineCapacity;
    }
}
