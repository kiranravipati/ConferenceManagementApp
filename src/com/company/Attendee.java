package com.company;

public class Attendee {
    private int id;
    private String name;
    private int age;

    Attendee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name;
    }

    public int getId() {
        return id;
    }

}
