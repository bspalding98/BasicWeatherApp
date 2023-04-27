package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Pipe;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Iterator;
import java.util.List;

// With locations. Better to use a database as it's embedded I think so when you retrieve location, exits will come with ???? Then retrieve it on demand.

public class Main {

    // JAVANIO Only
    // processed in blocks
        // Done with channels and buffers. and sometime selectors
    // channel is data source you a reading from or writing to.
        // TO use a data source as a channel. Need a class that implements the javaNIO.channel interface that can connect to the data source
    // Buffer is the container for the block of data you want to read or write.
        // Can specific size
        // Only typed, so can only hold one type of data
    // selectors - allow a single thread to manage IO for multiple channels - not covered because only needed in large enterprise applications
    // String can be byte based of char based, need two instance of javaIO to read and to write
    // JavaNIO you only need one instance of a channel to both read and write. Also it is always buffered so no need to wrap it


    // BUFFER
    // buffers capacity is the number of elemtns it can contain
    // position is the index of the next element that should be read or written
        // cannot be greater than the capacity
    // mark - used  by buffer.rest(). reset it to it's mark - so mark the point, then later can call rest to move it back to there

    // random acccess NIO
    // seekable byte channel interface
    // methods:
    //            read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
//                               updates the position accordingly.
//                               Note that now we're talking about the channel's position, not the byte buffer's position.
//                               Of course, the bytes will be placed into the buffer starting at its current position.
//            write(ByteBuffer) - the same as read, except it writes. There's one exception.
//                              If a datasource is opened in APPEND mode, then the first write will take place starting
//                              at the end of the datasource, rather than at position 0. After the write, the position
//                              will be updated accordingly.
//            position() - returns the channel's position.
//            position(long) - sets the channel's position to the passed value.
//            truncate(long) - truncates the size of the attached datasource to the passed value.
//            size() - returns the size of the attached datasource

    public static void main(String[] args) {
        // Using pipes only one way at a time. 1 thread reads, another writes
        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink(); // gets sink channel
                        ByteBuffer buffer = ByteBuffer.allocate(56);    // allocated buffer

                        for(int i=0; i<10; i++) {   // loop so thread terminates at some point
                            String currentTime = "The time is: " + System.currentTimeMillis();  // creating a string that include current time

                            buffer.put(currentTime.getBytes()); // putting it into buffer
                            buffer.flip();  // flipping

                            while(buffer.hasRemaining()) {  // writing string from buffer into channel
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);  // thread sleeps for 100 to give the reader thread a chance to read the source channel
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i=0; i<10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            new Thread(writer).start();
            new Thread(reader).start();
        } catch (IOException e ) {
            e.printStackTrace();
        }


        //Using binary code
        // This tiny code was to read and write to files
//        try (FileOutputStream binFile = new FileOutputStream("data.dat");
//             FileChannel binChannel = binFile.getChannel()) {
//            // Now writing all at once - chained put methods
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//            // CHAINED METHODS
////            byte[] outputBytes = "Hello World!".getBytes();
////            byte[] outputBytes2 = "Nice to meet you".getBytes();
////            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);  // can do this instead of below
////            buffer.flip();
//            byte[] outputBytes = "Hello World!".getBytes();
//            buffer.put(outputBytes);
//            long int1Pos = outputBytes.length;      // gettign starting position of line variable below
//            buffer.putInt(245);
//            long int2Pos = int1Pos + Integer.BYTES;
//            buffer.putInt(-98765);
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes2);
//            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
//            buffer.putInt(1000);
//            buffer.flip();  // to go through it from the start to write it to the file now
//            binChannel.write(buffer);
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//
//            // Now with RandomAccess using NIO
//
//            //Another way in comments - however if you wanted to read it all in reverse in one go this would not be good. you are just retrieving each one
////            ByteBuffer intBuffer = ByteBuffer.allocate(100);
////            channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println("int3 = "+intBuffer.getInt((int)int3Pos));
////            System.out.println("int2 = "+intBuffer.getInt((int)int2Pos));
////            System.out.println("int1 = "+intBuffer.getInt((int)int1Pos));
//
//            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
//            channel.position(int3Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            System.out.println("int3 = " + readBuffer.getInt());
//            readBuffer.flip();
//            channel.position(int2Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            System.out.println("int2 = " + readBuffer.getInt());
//            readBuffer.flip();
//            channel.position(int1Pos);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            System.out.println("int1 = " + readBuffer.getInt());
//
//            // FileChannel to copy files and pipes with threads - usually use a method in the Files class to copy, but this way could be better
//            RandomAccessFile copyFile = new RandomAccessFile("datacopy.dat", "rw");
//            FileChannel copyChannel = copyFile.getChannel();
//            // Setting channel because of above - it was relative, need to use it as an absolute value for this case
//            channel.position(0);
////            long numTransferred = copyChannel.transferFrom(channel, 0, channel.size()); // source channel, position to start, how much to copy (which is whole thing in this one)
//            // to transferTo a file
//            long numTransferred = channel.transferTo(0, channel.size(), copyChannel);
//            System.out.println("Num transferred = " + numTransferred);
//            channel.close();
//            ra.close();
//            copyChannel.close();


//            // writing it in a random fashion
//            byte[] outputString = "Hello, World!".getBytes();
//            long str1Pos = 0;
//            long newInt1Pos = outputString.length;
//            long newInt2Pos = newInt1Pos + Integer.BYTES;
//            byte[] outputString2 = "Nice to meet you".getBytes();
//            long str2Pos = newInt2Pos + Integer.BYTES;
//            long newInt3Pos = str2Pos + outputString2.length;
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            binChannel.position(newInt1Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(-98765);
//            intBuffer.flip();
//            binChannel.position(newInt2Pos);
//            binChannel.write(intBuffer);
//
//            intBuffer.flip();
//            intBuffer.putInt(1000);
//            intBuffer.flip();
//            binChannel.position(newInt3Pos);
//            binChannel.write(intBuffer);
//
//            binChannel.position(str1Pos);
//            binChannel.write(ByteBuffer.wrap(outputString));    // wrap() takes care of creating and flipping the buffer for us
//            binChannel.position(str2Pos);
//            binChannel.write(ByteBuffer.wrap(outputString2));








            // used a new buffer instead of old because old one would already have contents set to file - one used to write it
            // so this way starting fresh to ensure the file is read. what?
//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);   // readBuffer 100 bytes or end of file if smaller
//            readBuffer.flip();
//            // No we are just going along readBuffer and taking out each sized one?
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//            System.out.println("inputString = " + new String(inputString));
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());






//             FileChannel binChannel = binFile.getChannel()) {
//            // Need a buffer since writing to a file, we got the data, so can create a byte buffer to match the length of the data
//            // read cases you don't know the length of the data, so all you can do is a create a buffer of a given length and then parse what it receives
//            // Can create as many different buffers as you like
//            byte[] outputBytes = "Hello World!".getBytes(); // creating byte[] to store the String going in
//            // create a bytebuffer from the byte[] and the wrap() auto wraps the byte[] into the buffer, means buffer is backed by the byte[], mods to the array will change buffer, vice versa.
//            // wrap() want to use the byte[] as the buffer.
//            // also sets position to 0.
//            // capacity will be set to byte[] length
//            // mark will be undefined
////            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);   // auto sets position to 0 remember so dont need flip()
//            //Instead of using wrap(). allocate buffer based on length and then copying - doesn't auto set position to 0 so need to with allocate()
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//            buffer.flip();
////            binChannel.write(buffer);   // Writing to a file using the channel
//            // Want to know how many bytes are written could write this instead
//            int numBytes = binChannel.write(buffer);
//            System.out.println(numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);  // passing size of byte we want it to be with allocate() since we want an int. Integer.BYTES is 4 (default)
//            intBuffer.putInt(245);  // in put() you can also specific the index where to put it
//            //reset buffer to 0 so next line reads from start and not after the input - this is for int, long, short. Idk if more
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer); // starts read at buffers current position - READ FROM BUFFER WRITE TO CHANNEL
//            System.out.println(numBytes);
//            // close inputStream and file channel - which is auto done with try with resources
//
//            intBuffer.flip();   // Need this or will error from thing below
//            intBuffer.putInt(-98765);   // This errors because the buffers length is only 4 allocate() above and we already wrote one which moved it position 4 - so need flip()
//            intBuffer.flip();   // So back to start to write
//            numBytes = binChannel.write(intBuffer); // starts read at buffers current position
//            System.out.println(numBytes);
//
//            // READING USING JAVA.NIO
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            // use exsiting buffer to read it back in instead of creating new ones
//            buffer.flip();  // If you dont put this. still prints same thing but read() doesnt work because it is at the end. So if we change outputBytes the print will as well
//            long numBytesRead = channel.read(buffer);   // writing back into a ByteBuffer buffer above
//            if(buffer.hasArray()) { // does this is if the buffer has an array. use it no matter what?????????
//                System.out.println("byte buffer = " + new String(outputBytes));
//            }

            // relative reads - not passing in index
            // absolute reads - choosing where to read from??


//            //Abosulte - less flip() because starting at index is like a temp flip() - so doesn't actually move the position???
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));   // specify index position
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
            //Relative
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer); // read() writes the buffer
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt()); // getInt() read the buffer
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            // closing because did not use try with resources
//            channel.close();
//            ra.close();


            //NOW GOING TO USE JAVA.IO RANDOM ACCESS FILE CLASS TO READ IN THE DATA
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] b = new byte[outputBytes.length];    // getting the length of the byte[]
//            ra.read(b); // reading that length
//            System.out.println(new String(b));  // converts byte[] to a string
//
//            //read in two integers
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);



////            FileInputStream file = new FileInputStream("data.txt"); // creat file input stream
//            // getting a file channel.  said earlier when using channel you only need 1 for both reading and writing
//            // However if you create a file channel from a fileinput stream. It is only open from read. same with openstream. only open for writing.
//            // random depends on parameter passed to constructor (r or rw)
////            FileChannel channel = file.getChannel();
//            // when creating a buffer from channel. Need to specific a length. - each read you have to pass length of bufferRead
//            // old versions. Now better methods to read 1 line.
//            // Since code is small, will read the file in one shot
//            Path dataPath = Paths.get("data.txt");
//            //write - considered an isolated write. dont open a file, call a bunch of write methods, then close at the end
//                // write to it then close one bit at a time. So you could create a stringBuilder, then write everything once because everything is stored as 1 StringBuilder
//                // Could also write in chunks if it is big
//            // It writes bytes, not string
//            // .getBytes() turn string into a bytes because can only write bytes.
//            // .APPEND - write to a file that already exists and add.
//            //  If you don't specific - by default it will think you want to start fresh to create it if doesn't exist
//                // Or it will truncate it. Meaning will wipe overwrite it
//            Files.write(dataPath, "\nLine 5".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);  // Could add newLine at the end if wanted. so last enter already entered
//
//            //read
//            // If you did not want to read a huge txt files entire txt into memory. You should just use java.IO
//                // I think becuase if only parts you need to add more complex code like a byte() to convert, etc.
//            List<String> lines = Files.readAllLines(dataPath);  // Read it all at once with built in bufferedRead   -- UTF8 is default assumed in readAllLines - if want to change just ad second para
//            System.out.println(lines);
//            for(String line : lines) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
