import java.util.*;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<>();  // Making the object that stores multiple locations
    private static final List<String> directions = new ArrayList<>(Arrays.asList("WEST", "NORTH", "EAST", "SOUTH", "QUIT"));


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are  at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));



        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());
//      Can still delete part of the map so Location is not yet immutable
            if(loc == 0) break;

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            String[] words = direction.split(" ");
            int tempLoc = loc;
            for(String word : words) {
                if(directions.contains(word) || exits.containsKey(word)) {
                    String[] letter = word.split("");
                    if(exits.containsKey(letter[0])) loc = exits.get(letter[0]);
                }
            }
            if(tempLoc == loc) System.out.println("You cannot go in that direction");
        }
    }
}
