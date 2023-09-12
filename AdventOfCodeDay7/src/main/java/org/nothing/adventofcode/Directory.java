package org.nothing.adventofcode;

import java.util.Objects;
import java.util.ArrayList;

public class Directory {
    private String name;
	private int ID;
    private ArrayList<File> files = new ArrayList<File>();

    public Directory(int id, String nn) {
        this.ID = id;
        this.name = nn;
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
        return Objects.equals(hashCode(), otherDir.hashCode());
    }
}

