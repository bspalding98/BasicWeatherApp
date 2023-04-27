package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    //SET has no defined ordering and a set cannot contain duplicates. Oracle documentation defines it as chaotic
        // Want to check make sure there are no duplicates. Use a set instead of a list.
    //Apart of generic List. and takes a single type.
    // has add, remove, and clear
    // size and isEmpty
    // contains()
        // There is no way to retrieve an item from a set. Would need to iterate in a for loop or something.

    // Best is a hashSet class like HashMap. - like making a hashMap but just keeps the key????
        // Created from underlying hashMap I think.
    // SETS are good because operations on them are very fast.

    // Sets just store the name, not another reference??? Less memory
    // Sets can use mutable objects but be wary???

    // JAVA WARNS if using your own objects as a key in a map or element in set. You should override the equals and hashcode methods.
    // Because if you override equals, you also need to override the hashCode of the objects.
    // Need to be careful because you could make an equals method for a class. THen is could be subclassed and return true there...???
    // You can still add a duplicate if you do not compare hashCode as well.
    // Two objects compare equal, they must also have the same hashCode

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>(); // SolarSystem because it essentially holds all the planets and moons, etc.???
    private static Set<HeavenlyBody> planets = new HashSet<>(); // Just holds all the planets.
    public static void main(String[] args) {

        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(),tempMoon);
        temp.addSatellite(tempMoon); // Add it to Earth.

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(temp.getKey(), temp);
        temp.addSatellite(tempMoon); // Mars Moon

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(temp.getKey(), temp);
        temp.addSatellite(tempMoon); // Mars Moon

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("IO", 1.8);
        solarSystem.put(temp.getKey(), temp);
        temp.addSatellite(tempMoon); // Jupiter moon

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(temp.getKey(), temp);
        temp.addSatellite(tempMoon); // Jupiter moon

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(temp.getKey(), temp);
        temp.addSatellite(tempMoon); // Jupiter moon

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(temp.getKey(), temp);
        temp.addSatellite(tempMoon); // Jupiter moon

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getKey());
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));
        System.out.println("Moons of " + body.getKey());
        for(HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }

        // Could have been an idea to make a set for Moons in main to get moons alone
        // but can do it easily generate the union of the Set of each planets moons.
        // In Set theory: A union of two or more Sets is a Set containing all the elements of the Sets.
            // Because since Sets do not contain duplicates. Even if their are dups, it won't matter.
        // So like the for loop above where we get moons from one planet, we iterate through all planets and get all their moons into a variable.
        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {    // Iterating through the planets set
            moons.addAll(planet.getSatellites());   // adding each planets Set satellites which are the moons to our new Set called moon.
        }
        System.out.println("All Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }


        HeavenlyBody pluto = new Dwarf_Planet("Pluto", 842);    // Even though sets do not contain dups. There will now be two Plutos. Because
        // THey do no compare equal, same for a map key it would duplicate even though it shouldn't
        // WHY need to change EQUALS. Because default is a referential equality. So just checks if both point to same objects. If they don't, then they are not. SO uses pretty much ==
        planets.add(pluto);

        for(HeavenlyBody planet : planets) {
            System.out.println(planet);
//            System.out.println(planet.getName() + ": " + planet.getOrbitalPeriod());
        }


        // Test 2
        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals(pluto));   // Checking if it is actually working by making a false output.
        System.out.println(pluto.equals(earth1));


        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println("==================================");
        System.out.println();
        System.out.println("The solar system contains");
        for(HeavenlyBody heavenlyBody : solarSystem.values()) {
            System.out.println(heavenlyBody);
        }



    }
}
