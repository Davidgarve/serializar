package model;

import java.io.Serializable;

public class Theater implements Serializable {
    private String name;
    private int capacity;

    public Theater(String a, int b) {
        this.name = a;
        this.capacity = b;
    }

    @Override
    public String toString() {
        return this.name + " ," + this.capacity;
    }
}
