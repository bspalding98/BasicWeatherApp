package com.company;

import java.io.*;
import java.util.*;

// Created a class pretty much that behaves like a map but we can customise which to load its contents from an external force, a disk file in this case
// CHecked exceptions. IOexception. You cannot ignore these exceptions. Must be handled or code will not compile
    // Can catch them or throw them back up the call stack

// BufferedReader reads text from input stream and buffers the characters into a character array.
// More efficient because Filerwriteer and read read 1 byte at a time. where buffer reads chunks at a time.
// Can specific size of reader. 8k is default
    // so if file is under 8k char or bytes. entire File will be read at once

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>(); // static makes one instance, so even if multiple instances, always refer to the one place

    public static void main(String[] args) throws IOException {    // Will run after Static{} I think so created location objects then writes them to the file in here
                                                                    // throws IOException, because saying this method throws it. since it si checked, caller can catch or throw it.
//        FileWriter locFile = null;  // Must be here because of scope. If wasn't, locFIle in try{} would be destroyed after try{} execution
//        try{
//            locFile = new FileWriter("locations.txt");
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + ","  + location.getDescription() + "\n");
//            }
//        } catch(IOException e) {
//            System.out.println("In catch block");
//            e.printStackTrace();
//        } finally {
//            System.out.println("In finally block");
//            // Need to make sure that closing the file is at the end so if it runs or even if you get an exception. it still closes. But you must wrap that in an IOexception handle as well
//            try {
//                if(locFile != null) {
//                    System.out.println("Attempting to close locFile");
//                    locFile.close(); // VERY important. If not closed, it can become corrupted and also it could become locked somehow.
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        // SINCE we have throw IOException in main() can remove all catches or throws for IOException{}
//        FileWriter locFile = null;  // Must be here because of scope. If wasn't, locFIle in try{} would be destroyed after try{} execution
//        try{
//            locFile = new FileWriter("locations.txt");
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + ","  + location.getDescription() + "\n");
////                throw new IOException("Test exception thrown while writing");   // Testing to match sure catch and finally blocks work. Make sure you delete it though.
//            }
//        } finally {
//            System.out.println("In finally block");
//            if(locFile != null) {   // Don't need to bother closing it because there is nothing in it if this is false?
//                System.out.println("Attempting to close locFile");
//                locFile.close(); // VERY important. If not closed, it can become corrupted and also it could become locked somehow.
//            }
//        }

        // Now we have try with resources. So we do it this way
        // This ensures that a file is always closed whether the try works or an exception happens.
        // Does behave differently to the try finally{} version
            // difference is if an exception is thrown when closing the stream in addition to an error in the try{}
                // In try finally{} - exception thrown by the close() would have went up the stack
                // With resources it causes the exception to be suppressed and the exception from the try{} is thrown back up the stack
                // Better because throws like the base error up I guess.

        
        // Now with a BufferedWRiter
        try(BufferedWriter locFile = new BufferedWriter(new FileWriter("locations.txt"));
            BufferedWriter dirFile = new BufferedWriter(new FileWriter("directions.txt"))) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {  // This ensures when writing to the txt file we remove all quits to match direction_big - Not need becasue each time you make a Location object you are adding the exits in its constructor. So if you didnt do this would there be two quits???
                        // Could have also remove quit location ) from exit Map. THen just check input from user. BUt this is less code.
                        dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
//        try(FileWriter locFile = new FileWriter("locations.txt");
//            FileWriter dirFile = new FileWriter("directions.txt")) {
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for(String direction : location.getExits().keySet()) {
//                    // writing the ID for which location object this is in the locations map. Then passing in direction and value
//                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                }
//            }
//        } // Still can add a finally block. however do not add a close() since it is already done automatically. Can cause issues if so
    }

    static {    // this runs once when locations class instance is created - pretty it initialises the - Executes when classes load so no way to catch an exceptions. so cannot throw in check exceptions because they must be caught
        // attributes at the very start first thing. like initialize() in javafx

        // Loading the data into locations
        // Used bufferedReader now
        try (BufferedReader locFile = new BufferedReader(new FileReader("locations_big.txt"))) { // retrieving the data from a file instead of a keyboard now
            String input;
            while((input = locFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String description = data[1];
                System.out.println("Imported loc: " + loc + ": " + description);
                locations.put(loc, new Location(loc, description));
            }
        } catch (IOException e) { e.printStackTrace(); }
        // Scanner scanner = null;
//        try (Scanner scanner = new Scanner(new FileReader("locations_big.txt"))) { // retrieving the data from a file instead of a keyboard now
//            scanner.useDelimiter(",");  // What the fields are separated by
//            while(scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());  // Skips over the delimiter
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                locations.put(loc, new Location(loc, description));
//            }
//        } catch (IOException e) { e.printStackTrace(); }
//        finally { if(scanner != null) scanner.close(); }    // scanner.close() also closes all objects inside that have close()?

        // (loading data in exits) Now read the exits - probably better to make into an string[] by splitting "," and then assigning based off that like done before - think can even remove scanner and have buffereader = bufferedreader
        // Can get rid of scanner in try
        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;
            while((input = dirFile.readLine()) != null) {   // Assuming after it reads line of next line everytime automatically?
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println("Imported loc: " + loc + ": " + direction + ": " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        } catch (IOException e) { e.printStackTrace(); }
//        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {    // bufferedreader good practice because reads chunks at a time. 8k to be exact
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()) {
////                // getting location
////                int loc = scanner.nextInt();
////                scanner.skip(scanner.delimiter());
////                // getting direction
////                String direction = scanner.next();  // has to be next()
////                scanner.skip(scanner.delimiter());
////                // getting destination
////                String dest = scanner.nextLine();
////                int destination = Integer.parseInt(dest);
//                String input = scanner.nextLine();
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                System.out.println("Imported loc: " + loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) { e.printStackTrace(); }
//        finally { if(scanner != null) scanner.close(); }    // closes all because of closable implementation in other objects so when scanner closes, they auto close.



//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
//        locations.put(2, new Location(2, "You are  at the top of a hill"));
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
//        locations.put(4, new Location(4, "You are in a valley beside a stream"));
//        locations.put(5, new Location(5, "You are in the forest"));
//
//        locations.get(1).addExit("W", 2);
//        locations.get(1).addExit("E", 3);
//        locations.get(1).addExit("S", 4);
//        locations.get(1).addExit("N", 5);
//
//        locations.get(2).addExit("N", 5);
//
//        locations.get(3).addExit("W", 1);
//
//        locations.get(4).addExit("N", 1);
//        locations.get(4).addExit("W", 2);
//
//        locations.get(5).addExit("S", 1);
//        locations.get(5).addExit("W", 2);
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
