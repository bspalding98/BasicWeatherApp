package com.company;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

// WALKING THE FILE TREE
// Application has to find a file
// Another application is searching all files and directories below for a string
// To copy a whole directory, you have to walk the file tree to copy everything. Or only the fields in the root directory will be copied - doesn't walk

// Every file must be visited of skipped unless exception is throw

public class PrintNames extends SimpleFileVisitor<Path> {

    // what to do everytime we visit the file or a file
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    // This is what do to before you go to into the directory - we just printing the name of the path in this instance
    // If you want to copy a file tree. You would to handle the directory before you handle the directory. Needs to exists before you can copy into
    // If you want to delete it. You would want to handle it in the post because you want to get all the files in the directory before you delete it
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    // IOException will be thrown if we don't implement this
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
