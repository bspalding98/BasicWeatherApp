package com.company;

public class Car extends Vehicle {
//    fields or instance variables or member variables
    private boolean steering;
    private boolean gears;

//    constructors / setters
    public Car(double moving, boolean steering, boolean gears) {
        super(moving);
        this.steering = steering;
        this.gears = gears;
    }

//    getters
    public boolean isSteering() {
        return steering;
    }

    public boolean isGears() {
        return gears;
    }
}
