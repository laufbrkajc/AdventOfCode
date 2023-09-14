package org.nothing.adventofcode;

import com.google.common.graph.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Pattern;

public class App 
{
    public static void main(String[] args)
    {
        var scanner = new Scanner(System.in);
        String line = "";

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            Pattern cd = Pattern.compile("\\$ cd ");
            Pattern ls = Pattern.compile("\\$ ls ");

            if (line.matches(cd.pattern())) {
                String name = line.substring(4);
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
