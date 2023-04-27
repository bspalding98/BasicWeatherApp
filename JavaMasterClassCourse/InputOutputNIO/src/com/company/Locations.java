package com.company;

import java.io.*;
import java.nio.file.*;
import java.util.*;

// JAVA NIO - We were using javaIO streams this part. not just java NIO
// two buckets, those that deal with filesystem and those that deal with reading and writing data.
// In java IO, thread will block while it's waiting to read or write to a stream buffer
    // JAVA NIO will not block. THey are free to continue executing, so it's like a performance enhancement

// People think it was a step backwards, People think block IO is faster than non Blocking NIO
// Also working with javaNIO is more complex
// Many people still prefer the old IO method.
// java NIO - instead of processing one byte or character at a time. It will process one block at a time.
    // to accomplish this, need to use channels and buffers - in later videos


// Can read or write objects from a Path but it is a 2 step process



public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>(); // static makes one instance, so even if multiple instances, always refer to the one place

    public static void main(String[] args) throws IOException { // do not need catch because it has a throws
        // Using java.NIO - This is almost identical to the IO version - Only change is the way we create the bufferedWriter.
        // Path class is a replacement of the File class. more Robust when working with files. classes in javaNIO. work with path instances not file
        // Recommended practice to use path class when working with javaNIO when you can.
//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");   // can be: Path locPath = Paths.get("locations_big"); do i need txt tho?
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
//             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
//
//            for(Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for(String direction : location.getExits().keySet()) {
//                    if(!direction.equalsIgnoreCase("Q")) {
//                        dirFile.write(location.getLocationID() + "," + direction + "," +
//                                location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        } catch(IOException e) { System.out.println("IOException: " + e.getMessage()); }

        // Using objects now
        Path locPath = Paths.get("locations.dat");
        try(ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))) { // Only change is here. Double wrapping
            for(Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }
    }

    static {
        // Using javaNIO: - Can still use a String[] instead - nothing is changed here again is path variables.
//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try(Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()) {
//                int loc = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported loc: " + loc + ": " + description);
//                locations.put(loc, new Location(loc, description, null));
//            }
//        } catch(IOException e) { System.out.println(e.getMessage()); }
//
//        try(BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
//            String input;
//            while((input = dirFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                System.out.println(loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        }catch(IOException e) {
//            e.printStackTrace();
//        }

        // For Objects
        Path locPath = Paths.get("locations.dat");
        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while(!eof) {
                try {
                    Location location = (Location) locFile.readObject();    // because when it's stores as an object it's just a generic object. so need to cast
                    locations.put(location.getLocationID(), location);
                } catch(EOFException e) { eof = true; }
            }
        }
        catch(InvalidClassException e ) { System.out.println("InvalidClassException " + e.getMessage()); }
        catch(IOException e) { System.out.println("IOException " + e.getMessage()); }
        catch(ClassNotFoundException e) { System.out.println("ClassNotFoundException " + e.getMessage()); }

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
