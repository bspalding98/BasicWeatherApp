package com.company;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

//PROGRAMMING DEFENSIVELY
// Anything that doesn't need to be exposed to the outside isn't exposed.

// TO make this immutable you could just make user pass in Exits when constructing a location instance and also remove addExit()

public class Location implements Serializable { // All fields need to be serizalable for this to work. Luckily LinkedHashMap is (Map isnt)
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;   // String will be direction: north, south,etc. Integer will be locationID

    private long serialVersionUID = 1L;     // To declare a serialization class - Make sure to do this

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) this.exits = new LinkedHashMap<>(exits);   // Instantiating creates and hold the initial memory for the object? and returns a reference?
        else this.exits = new LinkedHashMap<>();
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
