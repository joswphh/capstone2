package org.example;
public enum Sides {
    AU_JUS("Au jus"),
    CHIPOTLE("chipotle");

    private String name;


    Sides(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}