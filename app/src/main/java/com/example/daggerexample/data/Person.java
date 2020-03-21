package com.example.daggerexample.data;

public class Person {

    private String name;

    private String description;

    public Person(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
