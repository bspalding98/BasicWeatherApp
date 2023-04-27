package com.company;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes { // Also prints actual description
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {    // enum good because it will break at compile time if not correct enum. - nested enum is auto static
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);   // THis is done so people can not manipulate the original HashSet. This is to make the class fully immutable
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    // Creating and equals and hashCode
    // This instance it's ok to just check name for equals because each planets and moon have unique names
    // However, for something else like a person. You may need to also check their DOB, etc.


    // Very easy to overload the equals(). Not override it. SO always use @Override, to check.
    // Have not overridden the code
    @Override
    public final boolean equals(Object obj) {   // Make sure it is of type Object so match Override base parameter.
        if(this == obj) {       // Saying if objects is equal to itself, as in the object is itself, return true.
            return true;
        }

        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

//    @Override
//    public boolean equals(Object obj) { // Differ signature, Object instead of HeavenlyBody. So above overloaded not overrid.
//        return super.equals(obj);
//    }


    @Override
    public final int hashCode() {
        return this.key.hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType) {          // static so the key can be obtained without having an instance of the HeavenlyBody to call the method on
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }
    



    public static final class Key { // Key is being used in a Map so need to override equals and hashCode methods. Can fix duplicates by referencing these ones in HeavenlyBody.
        private String name;
        private BodyTypes bodyType;
        
        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyTypes() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode()  + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())) return(this.bodyType) == key.getBodyTypes();
            else return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
