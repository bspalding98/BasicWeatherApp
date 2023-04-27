package com.company;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFiles extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFiles(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error access file: " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        // in order to figure out the path of the copy file - use path.relativise()
        // construct a relative path that resolves to a given path
        // so just the extra path from where we are starting??????????
        // root path is FileTree dir2.
        // destination tree is FileTree dir4 dir2copy
        // relative path  for root and set will be dir3 subdirectory / file1.txt
        //?????
        Path relativizedPath = sourceRoot.relativize(dir);  // relative path
        System.out.println("RelativizedPath = " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath); // to get the path for the copy
        System.out.println("Resolved path for copy = " + copyDir);
        try {
            Files.copy(dir, copyDir);   // calling copy() to make the copy
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return FileVisitResult.SKIP_SUBTREE;    // if exception occurs we skip the subtree. meaning you stop processing entries for the directory
        }

        return FileVisitResult.CONTINUE;
    }

    // figure out path of file and then copy it - similar to previstDirectory
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("RelativizedPath = " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("Resolved path for copy = " + copyDir);
        try {
            Files.copy(file, copyDir);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return FileVisitResult.CONTINUE;
    }
}
