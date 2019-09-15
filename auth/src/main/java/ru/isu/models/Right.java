package ru.isu.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Right implements Serializable {
    private long id;
    private String right;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
