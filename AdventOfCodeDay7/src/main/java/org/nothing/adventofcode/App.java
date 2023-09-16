package org.nothing.adventofcode;

import com.google.common.graph.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;

public class App 
{
    public static void main(String[] args)
    {
        MutableGraph<Directory> directoryGraph = GraphBuilder.directed().build();
        Scanner scanner;
        int dirCount = 0;
        Directory currentDir = new Directory(dirCount, "/");
        String line = "";

        try {
            scanner = new Scanner(new FileReader(args[0]));
        } catch (java.io.FileNotFoundException E) {
            System.out.println("Problem opening the file.");
            return;
        }

        // Interprets the input
        line = scanner.nextLine();
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            Directory newDir;
            dirCount++;

            if (line.matches("\\$ cd [a-z]+")) {
                String name = line.substring(5);

                newDir = new Directory(dirCount, name, currentDir);
                directoryGraph.putEdge(currentDir, newDir);
                currentDir = newDir;

            } else if (line.matches("\\$ cd \\.\\.")) {
                if (currentDir.getParent() == null) {
                    return;
                }
                currentDir = currentDir.getParent();

            } else if (line.matches("[0-9]* .*")) {
                String[] parts = line.split(" ");
                File file = new File(parts[1], Double.parseDouble(parts[0]));
                currentDir.getFiles().add(file);
            } else {
                System.out.println("Unhandled case:");
                System.out.println("  |>" + line);
            }
        }

    }
    
    public static double du(Graph<Directory> dirGraph, Directory startingDirectory)
    {
        Set<Directory> successors = dirGraph.successors(startingDirectory);
        double totalFileSize = 0;
        
        if (!successors.isEmpty()) {
            for (Directory suc : successors) {
                totalFileSize += du(dirGraph, suc);
            }
        }

        for (File file: startingDirectory.getFiles()) {
            totalFileSize += file.size();
        }

        return totalFileSize;
    }
}
