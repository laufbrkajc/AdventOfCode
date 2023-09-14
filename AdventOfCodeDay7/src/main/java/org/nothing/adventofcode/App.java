package org.nothing.adventofcode;

import com.google.common.graph.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;

public class App 
{
    public static void main(String[] args)
    {
        var dirA = new Directory(0, "root");
        var dirB = new Directory(1, "etc");
        var dirC = new Directory(2, "home");
        var dirD = new Directory(3, "madrad");

        dirB.getFiles().add(new File("wgetrc", 1024));
        dirC.getFiles().add(new File("users", 78));
        dirD.getFiles().add(new File(".bashrc", 24));

        MutableGraph<Directory> dirTree = GraphBuilder.directed().build();

        dirTree.putEdge(dirA, dirB);
        dirTree.putEdge(dirA, dirC);
        dirTree.putEdge(dirC, dirD);

        System.out.println(du(dirTree, dirC));
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
