package org.nothing.adventofcode;

import com.google.common.graph.*;
import java.util.Scanner;
import java.util.ArrayList;

public class App 
{
    public static void main(String[] args)
    {
        var dirs = new ArrayList<Directory>();
        String[] names = {"AAA", "HHH", "III", "MMM", "OOO"};

        for (int i = 0; i < 5; i++) {
            dirs.add(new Directory(i, names[i]));
        }

        dirs.get(2).getFiles().add(new File("file0", 12345));
    }
}
