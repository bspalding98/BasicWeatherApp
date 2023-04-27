package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//PROGRAMMING DEFENSIVELY
// Anything that doesn't need to be exposed to the outside isn't exposed.

// TO make this immutable you could just make user pass in Exits when constructing a location instance and also remove addExit()

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;   // String will be direction: north, south,etc. Integer will be locationID

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new LinkedHashMap<>();   // Instantiating creates and hold the initial memory for the object? and returns a reference?
        this.exits.put("Q", 0);  // Add the exit of the game. Put here instead of main because it is always the same.
    }

    protected void addExit(String direction, int location) {    // protected so only available to our package and subclasses of location class.
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }
}
