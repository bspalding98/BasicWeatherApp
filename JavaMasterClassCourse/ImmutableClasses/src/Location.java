import java.util.HashMap;
import java.util.Map;

public class Location { // Class wasn't defined as final but all the fields were which is still the same thing. Not allowing the class the be subclassed. ? I thought but in exercise I had to make it final as well
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        // NULL can be passed in as third parameter and still make the game crash at run time. So to fix it do below.
        if(exits != null) this.exits = new HashMap<>(exits); // This stops it from being altered by making a copy again like getExits() I think.
        else this.exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    // Changed the constructor to add the exists in when creating it so no longer need the setter below - trying to make it immutable.

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
