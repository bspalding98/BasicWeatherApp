package com.company;

import java.io.*;
import java.util.*;

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
//CANNOT READ WRITE OBJECTS. DOESNT CONTAIN READ OBJECT AND WRITE OBJECT METHODS.
// Not using Bufferedreader/writer because it is sequential. Cannot have other instance inside it like buffereedreader



// Binary data
// Advantage is do not need to parse data into various data's stored.
    // Byte stream can be used to read and write any java primitive types: byte, int, double, etc.
    // Can also handle string variables even though it is not a primitive type.
// Follows same pattern
    // Differ is a file input and output instead of filereaders and filewriters

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<>(); // static makes one instance, so even if multiple instances, always refer to the one place
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<>();
    private static RandomAccessFile ra;

    public static void main(String[] args) throws IOException { // do not need catch because it has a throws
        // Using Random:
        // Pointer is default position 0, so no need for seek for start
        try (RandomAccessFile rao = new RandomAccessFile("locations_rand.dat", "rwd")) {    // "rwd" read and writing synchronously - same time
            // Each index record contains 3 integers. location ID, offset for location, location size
            rao.writeInt(locations.size());
            int indexSize = locations.size() * 3 * Integer.BYTES;   // 3 because our index stores 3 ints, ID, offset, and length. Then * by the size of an integer which is Integer.BYTES
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);   // gives us offset for location section.
                // Pretty much above, we are assigning the new filePointer position to the end of the indexSize we already wrote to the file
                // (which is one object I think). THen we need to account for the int we are about to write to the file. locationStart. int is 4 bytes so add that as well.
                // Cast to int because filePoint is a long. Normally always try use Int as good practice if can
            rao.writeInt(locationStart);
            // disk access is expensive so write all locations and then index as a whole.
            // Jump back to file when finished writing locations. - save current position of filePOints to jump back to it when we want to write the index
            long indexStart = rao.getFilePointer();


            int startPointer = locationStart;   // Set the offset to a variable to calculate the location records length
            rao.seek(startPointer); // Seek to move to the fielPointer to first location offset. Only need to do it once because after we write sequentially.
            for(Location location : locations.values()) {
                rao.writeInt(location.getLocationID()); // writing location ID
                rao.writeUTF(location.getDescription());    // description
                StringBuilder builder = new StringBuilder();    // Make a string builder to store exits together as it's an object. Not a literal type
                for(String direction : location.getExits().keySet()) {  // builds Exits for each location
                    if(!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");    // probs check for this at the end of the file and remove it.
                        // Writing out like this
                        // direction, location ID, direction, locationID
                        // N, 1, U, 2
                    }
                }
                rao.writeUTF(builder.toString());   // Writing the exits

                // Now creating the index reference for it
                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));    // start byte is startPOinter value. record length, it length of filePOints - startPointer
                index.put(location.getLocationID(), record);    // Adding the index record to the location ID

                startPointer = (int) rao.getFilePointer();  // update the startPoint for the next location
            }
            //Now written the locations to the file, so now can write our indexes
            rao.seek(indexStart);   // seeking to offset previously stored
            for(Integer locationID : index.keySet()) {  // looping through all index records and then writing them to the file
                rao.writeInt(locationID);
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }
        }
    }

    //FOr random access file Index - only call seek() when we want to jump to a different offset in the file
    //1. The first four bytes will contain the number of locations (bytes 0 - 3)
    //2. The next four bytes will contain the start offset of the locations section (bytes 4 - 7)
    //3. The next section of the file will contain the index (the index is 1629 bytes long. It  will start at the byte 8 and end at byte 1699).
    //4. The final section of the file will contain the location records (the data). It will start at byte 1700.
    static {
        // Because of random access
        // No loading the locations into memory anymore. We load location on demand now
        // Locations.main() will no longer work because it depends on all the locations being loaded into memory.
            // So to run the method again. would have to change static initializer to load all the locations but would defeat the purpose
        // recommends, if you need main again lecture 243. 6:30 onwards
        // Now want to read the index from the file

        try {
            ra = new RandomAccessFile("locations_rand.dat", "rwd"); // opens file
            int numLocations = ra.readInt();    // read num of location - future reference if want to modify code. good practice
            long locationStartPoint = ra.readInt(); // also offset

            while(ra.getFilePointer() < locationStartPoint) {   // load index into memory - read index by loop until the filePoint reaches the locations offset
                int locationID = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();

                // Then creating a new index record
                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationID, record);
            }
        }
        catch(IOException e ) { System.out.println("IOException in static initializer: " + e.getMessage()); }

//        // Using serialization:
//        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
//            boolean eof = false;
//            while (!eof) {
//                try {
//                    Location location = (Location) locFile.readObject();
//                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
//                    System.out.println("Found " + location.getExits().size() + " exits");
//
//                    locations.put(location.getLocationID(), location);
//                } catch (EOFException e) {
//                    eof = true;
//                }
//            }
//        }
//        catch (InvalidClassException e) { System.out.println("InvalidClassException " + e.getMessage()); }
//        catch (IOException io) { System.out.println("IO Exception " + io.getMessage()); }
//        catch (ClassNotFoundException e) { System.out.println("ClassNotFoundException " + e.getMessage()); }
    }


    // Since we are using random access reader and writer we do not have locations pre loaded. So everytime we move we must get it quickly using this method.
    // which is done with index which is initialised in static{}
    public Location getLocation(int locationID) throws IOException {
        // grabs location from location file
        IndexRecord record = index.get(locationID); // Finding where it is in file using the index associated with the ID
        ra.seek(record.getStartByte()); // Moves to starting position
        int id = ra.readInt();  // reads ID
        String description = ra.readUTF();  // reads description - readUTF reads length first, then the bytes that the length says
        String exits = ra.readUTF();    // reads all its exits
        String[] exitPart = new String(exits).split(",");   // Creates an array to split all its exits and remove the ","

        Location location = new Location(locationID, description, null);    // initially null to create an empty new hashMap in location.

        // creates the exits and appends them
        if(locationID != 0) {
            for(int i=0; i<exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i+1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }
        return location;
    }

    public void close() throws IOException { ra.close(); }  // throwing exception because we are going to let all the exceptions bubble up to the operating system. The app will exit and the exception will be written to the console.

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
