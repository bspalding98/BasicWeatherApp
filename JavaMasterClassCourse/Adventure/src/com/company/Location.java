package com.company;

import java.util.HashMap;
import java.util.Map;

//PROGRAMMING DEFENSIVELY
// Anything that doesn't need to be exposed to the outside isn't exposed.

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;   // String will be direction: north, south,etc. Integer will be locationID

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>();   // Instantiating creates and hold the initial memory for the object? and returns a reference?
        this.exits.put("Q", 0);  // Add the exit of the game. Put here instead of main because it is always the same.
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        // This is a shallow copy but I think because the reference is final, It won't affect the original map if you add or remove from this one????
        // So whenever we get a copy of this it is a copy of the original????? I am a little confused.
        return new HashMap<>(exits);        // Instead of just return the exists map, return a new HashMap of exits as the constructor.
        // Means next HashMap is creating with the exists of the Exists HashMap
        // Useful technique is because nothing outside of the class can change exits.
        // So if the calling programs won't to add or remove mappings from it. the exits mapping field won't be affected.
        // because getter created a copy.
        // SO if someone calls the getter to change the map. it won't change the original exists from this class, just the copy???
        // So the original for our game cannot be altered.
    }
}
