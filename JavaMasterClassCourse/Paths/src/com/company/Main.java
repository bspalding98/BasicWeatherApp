package com.company;

// .getfault() gets the default directory path which is the IDEA. why when we do .getpath after and create the file. It's created in here?????
    // Becuase .getPath has a built in function .getDefault() that we do not need to write.


// Can create files empty
// But normally would only create a file when you write to it - NIO using streams or filechannel.


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    // doing copyfile - overrider
        try {
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING); // This third parameter overrides the file if it already exists
//
//            // Copying Directories - this way only the directory is copied, not the files within it by default
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);    // be good if you are using temp files

//            //Moving files
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);

//            // rename files
//            Path fileToRename = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path newFileName = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Files.move(fileToRename, newFileName);  // Moves the into the same essentially so it is renaming pretty much

//            // deleting files
//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
////            Files.delete(fileToDelete);
//            // If want to check if file exists first to not get an exception can do this
//            Files.deleteIfExists(fileToDelete);
//            // Can delete directories but they have to empty and you have to walk the file tree - in future examples


            // Creating a file  -- CANNOT USE TO CREATE DIRECTORIES
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.createFile(fileToCreate);

            // Create directory method
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir5");
//            Files.createDirectory(dirToCreate);

            // Creating a directory path with multiple
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
            //OR
//            Path dirToCreate = FileSystems.getDefault().getPath("Exampels\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");
//            Files.createDirectories(dirToCreate);


            // GETTING FILES ATTRIBUTES - FIles metadata
            // Single attribute
            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1\\file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            // All attributes
            // creating an instance of a class that implemented an interface, containing methods which can  retrieve each individual attribute
            // basic covers a set of attributes that is common in all OS - using that one
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified = " + attrs.lastModifiedTime());
            System.out.println("Created = " + attrs.creationTime());
            System.out.println("Is directory = " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());   // meaning is not a directory or anything


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");   // default is path where Project name directory is.  - Best way if possible to do
//            // Because it gets as much already with methods so you have less chance of entering it in wrong.
//        printFile(path);    // reads the file and prints it
//
////        Path filePath = FileSystems.getDefault().getPath("SubdirectoryFile.txt");
////        printFile(filePath);    // File cannot be found due to the path we gave is incorrect
//        //FIX
////        Path filePath = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");  // Can also do single path instead if wish
//        // Another way
//        Path filePath = Paths.get(".", "files", "SubdirectoryFile.txt");    // Must still be passed in the correct order
//        printFile(filePath);
//
//        // outhere is outside working directory. so cannt do .getdefault.getPath
//        // How to do it
////        filePath = Paths.get("C:\\Users\\boyd9\\Documents\\JavaCourse\\OutThere.txt.txt");  // doing .txt.txt because I name it improperly - Known as absolute path
//        // Can also split it up
//        filePath = Paths.get("C:", "Users\\boyd9\\Documents\\JavaCourse", "OutThere.txt.txt");
//        printFile(filePath);
//
//        // DOT refers to current directory on both Windows and unix systems
//        filePath = Paths.get(".");  // 1 dot gets the current directory, 2 dots gets the parent
//        System.out.println(filePath.toAbsolutePath());  // Gets absolute path
//
//
//        // Can successfully create path to files without an error until you try to use it
//        // IO works the same way
//        // Is abstract until you try to access the path or file
//        // Below doesn't error even though it doesn't exist
//        Path path3 = FileSystems.getDefault().getPath("thisfilledoesntexist.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        // TO create a file though the directory does have to exist, however the file doesn't
//
//        // Can check if the file or directory exists before trying to use it:
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = " + Files.exists(filePath));   // boolean of whether it exists or not
//        System.out.println("Exists = " + Files.exists(path3));
//        // Files.nonExists() returns true when the files or directory doesn't exists
//        // Could always just let the catch{} in printFile just catch it as well
//        // Files.isreadable, iswritable, isexecutable - methods to check files
//
//    }
//
//
//    // using NIO to read through IO? That how it works I think with bufferedReader being used
//    private static void printFile(Path path) {
//        // Could use NIO one below but need to hand throws IOException for here and main then
////            List<String> lines = Files.readAllLines(path);  // Read it all at once with built in bufferedRead   -- UTF8 is default assumed in readAllLines - if want to change just ad second para
////            System.out.println(lines);
////            for(String line : lines) {
////                System.out.println(line);
//        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
//            String line;
//            while((line = fileReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch(IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
