package com.company;

import java.util.ArrayList;

public class Gearbox {                                                                                  // Base class
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;    // Was gearNumber for purpose below. changed to fix the confusion
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        for(int i = 0; i < maxGears; i ++) {
            addGear(i, i*5.3);
        }
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio) { // is part of using the Gearbox. Are apart of building gearbox. not adding it. So better in constructor so they you do not need to manually create them unless you wanted a specfic ratio.
        if((number > 0) && (number <= maxGears)) {
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGear) {
        if((newGear >= 0) && (newGear < this.gears.size()) && (this.clutchIsIn)) {
            this.currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("Grind!");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if(clutchIsIn) {
            System.out.println("Scream!!");
            return 0.0;
        }
        return  (revs * gears.get(currentGear).getRatio());
    }

    private class Gear { // Be private because you do not want people interacting with gear alone. only when they interact with gearbox.        // Inner class. MUST be inside base class but below everything else.
                         // Nothing but the Gearbox needs to know about the gear. So just depends how your program wants to work. If stock program to figure out ordering it wouldnt be private.
        // Can still access out class GearBox. So ensure you use this.x for variables
        private int gearNumber; // Shadowing gearNumber which is not good coz confusing             // Doesn't make sense to refer to a gear unless we are talking about a gearbox. So this is why you would use it as an inner class

        public double getRatio() {
            return ratio;
        }

        private double ratio;   // Because it is the same as one on the outer.                      // The gear isn't useful in its own right. Its coupled with a gearbox which makes it useful
                                                                                                    // Doesn't make sense to refer to something unless it's within the context. Like this one.
        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;   // Want to reference one form Gearbox. Need to do Gearbox.this.gearNumber
            this.ratio = ratio;
        }

        public double driveSpeed(int revs) {
            return revs * (this.ratio);
        }
    }
}
