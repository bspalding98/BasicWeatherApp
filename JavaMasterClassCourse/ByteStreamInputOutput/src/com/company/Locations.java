package com.company;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//Serialization
// Translating data structure or object into a format that can be stored and recreated. Called serialization
    // Declare a serialization field and must be private only if we want to specifically use serialization in input and outputstream, or cna be compatibility issues down the road
// Two objects that we serialized point to the same object
    // It will only contain one copy of an instance.
// Is not unique across files. So if there are two files and two instance of same thing. Would be total of 2. one in each. not two in each

// Random access file
    // Only reads certain parts from the file
    // EG. have thousands of locations, so many don't want to store the location in memory. So instead everytime the user moved to a new location.
        // We would read that location from that file. To do that need to jump to the place in the files where it is stored.
// So rather than reading it sequentially, need to read it in a random fashion - random access file class
    // Need to know file pointer
        // Is an offset in the file where the next Read or Write will start from..
        // EG. If set to 100. The next time we call a read or write method. Would start at position 100. if reading an int. 100-103 will be read as int is 4bytes.
        // Referred to as a record. Location is a record.
// Since there is not a set length of bytes for each location
// We firstly need to get the index of each location and then do it I think?
    //Normally index contian unique identifier for each data record, the offset of the record in the file, and the length of the record. which is 12 bytes in java?
    // Index for this one is going to contain the locationID, locations offset, and record length which matches the typical length.

//Always load the index into memory at the start, not each time go to a new location
    // This is because data stored in memory RAM is much fast than disk Hard Drive



// Binary data
// Advantage is do not need to parse data into various data's stored.
    // Byte stream can be used to read and write any java primitive types: byte, int, double, etc.
    // Can also handle string variables even though it is not a primitive type.
// Follows same pattern
    // Differ is a file input and output instead of filereaders and filewriters

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>(); // static makes one instance, so even if multiple instances, always refer to the one place

    public static void main(String[] args) throws IOException { // do not need catch because it has a throws
        // Using serialization: this contains all the exits in it as well I'm pretty sure
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for(Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }


        // Writing both locations and exits txt to one dat file
//        try (DataOutputStream locFile = new DataOutputStream(is ounew BufferedOutputStream(new FileOutputStream("locations.dat")))) {    // .dat since no longer is a txt file and main reason is to no conflict with current txt. and also showing it isn't txt
//            for(Location location : locations.values()) {
//                locFile.writeInt(location.getLocationID()); // writes an int
//                locFile.writeUTF(location.getDescription()); // Writes a string
//                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription()); // printing what we are writing
//                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");  // printing how many exits for each location - minus 1 from total size because don't want to write in quit
//                locFile.writeInt(location.getExits().size() - 1);
//                for(String direction : location.getExits().keySet()) {
//                    if(!direction.equalsIgnoreCase("Q")) {
//                        System.out.println("\t\t" + direction + ", " + location.getExits().get(direction)); // prints what direction we are getting
//                        locFile.writeUTF(direction);
//                        locFile.writeInt(location.getExits().get(direction));   // Destination
//                    }
//                }
//            }
//        }
    }

    //FOr random access file Index - only call seek() when we want to jump to a different offset in the file
    //1. The first four bytes will contain the number of locations (bytes 0 - 3)
    //2. The next four bytes will contain the start offset of the locations section (bytes 4 - 7)
    //3. The next section of the file will contain the index (the index is 1629 bytes long. It  will start at the byte 8 and end at byte 1699).
    //4. The final section of the file will contain the location records (the data). It will start at byte 1700.
    static {
        // Using serialization:
        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();    // Takes care of reading all its fields and returns an object - why we cast it to the object
                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits");

                    locations.put(location.getLocationID(), location);  // Then just need to add it.
                } catch (EOFException e) {  // End of file catch
                    eof = true;
                }
            }
        }
        catch (InvalidClassException e) { System.out.println("InvalidClassException " + e.getMessage()); }  // IOE would catch this because this is a subclass of IOE
        catch (IOException io) { System.out.println("IO Exception " + io.getMessage()); }
        // Thrown when the runtime reads an object from the stream and cannot find the corresponding class on the class path.
        // EG. If another application that did not contain the Location class tries to read the objects inside the location.dat file
        // It would get a classNotFoundException
        catch (ClassNotFoundException e) { System.out.println("ClassNotFoundException " + e.getMessage()); }

        //Using binary output: MAKE SURE IF THERE ARE ERRORS TO CHECK BRACKETS BECAUSE IT WILL ERROR SEVERAL THINGS BUT WHERE THE BRACKET IS MISSING
//        try(DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false; // eof = end of file
//            while(!eof) {
//                try {
//                    Map<String, Integer> exits = new LinkedHashMap<>();
//                    int locID = locFile.readInt();
//                    String description = locFile.readUTF();
//                    int numExits = locFile.readInt();
//                    System.out.println("Read location " + locID + " : " + description);
//                    System.out.println("Found " + numExits + " exits");
//                    for(int i=0; i<numExits; i++) {
//                        String direction = locFile.readUTF();
//                        int destination = locFile.readInt();
//                        exits.put(direction, destination);
//                        System.out.println("\t\t" + direction + "," + destination);
//                    }
//                    locations.put(locID, new Location (locID, description, exits));
//                } catch (EOFException e) { eof = true; }    // when empty or reaches end. it terminates here automatically
//            }
//        } catch(IOException io) { System.out.println("IO Exception"); } // now this catches specific things and not several like empty dat file like before - added eof stuff - like methods. Have them so you can pin down error area

//        // Read Locations:
//        try (BufferedReader locFile = new BufferedReader(new FileReader("locations_big.txt"))) { // retrieving the data from a file instead of a keyboard now
//            String input;
//            while((input = locFile.readLine()) != null) {
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String description = data[1];
//                System.out.println("Imported loc: " + loc + ": " + description);
//                locations.put(loc, new Location(loc, description));
//            }
//        } catch (IOException e) { e.printStackTrace(); }
//
//        // Read Exits:
//        try (BufferedReader dirFile = new BufferedReader(new FileReader("directions_big.txt"))) {
//            String input;
//            while((input = dirFile.readLine()) != null) {   // Assuming after it reads line of next line everytime automatically?
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//                System.out.println("Imported loc: " + loc + ": " + direction + ": " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        } catch (IOException e) { e.printStackTrace(); }
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
