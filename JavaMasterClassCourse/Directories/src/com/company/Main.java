package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
// WAlking a file tree - reading directories

// FIle stores - Harddrives
// C drive is a file store

// Filters: - globs
    // ? would match any path that contains exactly one character. EG> ??? = exactly three character
    // myfile* matches any paths that begin with myfile
    // * matches any string (Which can contain any number of characters)
    // *.dat will match any path with the .dat extension
    // *.{dat,txt} will match any path that has the extension .dat or .txt
    // b?*.txt match any path that are at least two characters long and begin with the character b (the ? forces a second character, and the * matches 0 or more characters)

public class Main {

    public static void main(String[] args) {
//        // overriding a filter to check for only files - only way to check with stuff related to directories is overriding manually
////        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
////            public boolean accept(Path path) throws IOException {
////                return Files.isRegularFile(path);
////            }
////        };
//        // Same but with Lambda expression
////        DirectoryStream.Filter<Path> filter = path -> Files.isRegularFile(path);
//        // then more with method reference
//        DirectoryStream.Filter<Path> filter = Files::isRegularFile;
//
//
//	// fills.new directory string() return a string that needs to closed to using try with resources
//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
//        // accepts filter as second parameter so specify which file types you want. Also known as a glob - similar to a regular expression - check filters above
////        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, "*.dat")) { // DirectoryStream is an interface and implements the Iterate interface so can just for loop it as iterator auto is implemented?
//        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) { // implementing own filter from the one created above
//
//                // only the contents directly in the Dir2 is displayed. So nothing Dir3 is printed.
//            for(Path file: contents) {
//                System.out.println(file.getFileName());
//            }
//        } catch (IOException | DirectoryIteratorException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        // Since different OS have different separators in paths, you can use built in ones that will work for every OS
//        // for windows it's \   but with programming need to use \\ to showcase it's a \ because normally \ alone means something else
//        // This is also good to do because if we make an application. If we hardcoded. Would not work on certain OS
//        String separator = File.separator;
//        System.out.println(separator);
//        separator = FileSystems.getDefault().getSeparator();
//        System.out.println(separator);
//
//        // This is how you build a code properly- first line is the hardcoded way. The second is the better one
////        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
////        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
//        // For long paths you would probably just use a string builder
//
//        // Create temporary files in default temp file
//        try {
//            Path tempFile = Files.createTempFile("myapp", ".appext");   // first para == prefix (start of file), suffix = file extension the end, third para - type file attr. but or temp files no need
//            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
//        }catch (IOException e) { System.out.println(e.getMessage()); }
//
//        // can store the temp file in a specific directory using another version of the createTempFile(), uses more parameters as well as a parent directory path, also can do for directories
//        // Getting file stores like C drive
//        // This gets name
//        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
//        for(FileStore store : stores) {
//            System.out.println(store.name());
//            // This gets the letter
//            System.out.println(store);
//        }
//
//        // Another way - not good I think because it prints all even if not used. like a usb port??
//        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
//        for(Path path : rootPaths) {
//            System.out.println(path);
//        }


        // Cannot not make assumptions about the order in which file directories are visited.
        System.out.println("--- Walking tree for Dir2 ---");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2"); // getting this path
        try {
            Files.walkFileTree(dir2Path, new PrintNames()); // walking the path with class over overridden methods to continue throw it???
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Can specific the number of levels to traverse and file visit options if you do the other one with 4 parameters



        // THis is another way someone did it to go through a file tree
        // It essentially checks isDirectory and if it is. it uses recursion to go through the directory
        // If it is just a file, it runs else {} and just prints the file and moves on
//        public class Main {
//
//            public static void main(String[] args) {
//
//                Path path = FileSystems.getDefault().getPath("FileTree");
//                printTree(path);
//            }
//
//            private static void printTree(Path path) {
//                try(DirectoryStream<Path> content = Files.newDirectoryStream(path)) {
//                    for(Path file : content) {
//                        if(Files.isDirectory(file)) {
//                            printTree(file);
//                        } else {
//                            System.out.println(file.toAbsolutePath());
//                        }
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        // someone said if you pass a Path that points to a file instead of a directory. It would throw a NoDirectoryException. FIX
//        public static void walkTree(Path path) {
//            if (Files.isDirectory(path)) {
//                try (DirectoryStream<Path> contents = Files.newDirectoryStream(path)) {
//                    System.out.println(path.toAbsolutePath());
//                    contents.forEach(p -> {
//                        if (Files.isDirectory(p)) {
//                            walkTree(p);
//                        } else {
//                            System.out.println(p.toAbsolutePath());
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                System.out.println(path.toAbsolutePath());
//            }
//        }

        // WORKS
        System.out.println("---Copy Dir2 to Dir4/Dir2Copy---");
        // Path we are going to be copying to
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));    // dir2Path is our source path from above
        }catch (IOException e) { System.out.println(e.getMessage()); }

        // can pass for paramter to a copy method to specific what would happen if it already exists



        //HOW TO MAP COMMON JAVA IO OPERATIONS TO JAVA NIO
        // Paths
            // NIO.path is better than IO
            //  can use file.topath() to convert and oldstyle file isntance to the preferred java NIO instance
        //EG>
        File file = new File("C:\\Example\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        // Once we have a path object - we can go ahead and use it with all the java NIO methods

        //Path.resolve()
        // Must do it when file instance is created though
        File parent = new File("C:\\Examples"); // parent path - file part?
        File resolvedFile = new File(parent, "dir\\file.txt");  // child part - is a string
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("C:\\Examples", "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        //OR
        Path parentPath = Paths.get("C:\\Examples");
        Path childRelativePath = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        // Also learnt how to call the files.move and delete() to do that stuff
        // File.renameTo() and File.delete()

        // Working directory. FileSystem.getDefault()
        // Doing it in IO, need to use a File instance, several ways but some have drawbacks
            // WHy using NIO is better

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println(workingDirectory);

        //Listing contents of directory NIO used directoryStream
        // IO use toe File.list() and File.listFiles()
        // list() array of strings - also can pass an additional filter method() to list()
        // listFiles() array of files

        System.out.println("---print Dir2 contents using list() ---");
        File dir2File = new File(workingDirectory, "\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        for(int i=0; i<dir2Contents.length; i++) {
            System.out.println("i = " + i + ":" + dir2Contents[i]);
        }

        System.out.println("--- print Dir2 contents using listFiles() ---");
        File[] dir2Files = dir2File.listFiles();
        for(int i=0; i<dir2Files.length; i++) {
            System.out.println("i = " + i + ":" + dir2Files[i].getName());  // file objects so need .getName()
        }
    }
}
