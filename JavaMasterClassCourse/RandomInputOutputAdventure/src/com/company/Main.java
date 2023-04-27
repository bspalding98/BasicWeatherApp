package com.company;

import java.io.IOException;
import java.util.*;

public class Main {
    private static Locations locations = new Locations();
    private static final List<String> directions = new ArrayList<>(Arrays.asList("WEST", "NORTH", "EAST", "SOUTH", "QUIT"));


    public static void main(String[] args) throws IOException { // Can no longer do the written words.
        Scanner scanner = new Scanner(System.in);


        Location currentLocation = locations.getLocation(1);
        while(true) {
            System.out.println(currentLocation.getDescription());
            if(currentLocation.getLocationID() == 0) break;

            Map<String, Integer> exits = currentLocation.getExits();
            System.out.print("Available exits are: ");
            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            String[] words = direction.split(" ");
            int tempLoc = currentLocation.getLocationID();
            for(String word : words) {
                if(directions.contains(word) || exits.containsKey(word)) {
                    String[] letter = word.split("");
                    if(exits.containsKey(letter[0])) {
                        currentLocation = locations.getLocation(currentLocation.getExits().get(direction));
                    }
                }
            }
            if(tempLoc == currentLocation.getLocationID()) System.out.println("You cannot go in that direction");
        }
    }
}
