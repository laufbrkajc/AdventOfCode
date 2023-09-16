package org.nothing.adventofcode;

import java.util.Objects;
import java.util.ArrayList;

public class Directory {
    private Directory parent = null;
    private String name;
	private int ID;
    private ArrayList<File> files = new ArrayList<File>();

    public Directory(int id, String nn) {
        this.ID = id;
        this.name = nn;
    }

    public Directory(int id, String nn, Directory pp) {
        this.ID = id;
        this.name = nn;
        this.parent = pp;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public ArrayList<File> getFiles() {
		return files;
	}

    @Override
    public int hashCode() {
        return Objects.hash(files, ID);
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Directory otherDir = (Directory) o;
        return this.hashCode() == otherDir.hashCode();
    }
}
