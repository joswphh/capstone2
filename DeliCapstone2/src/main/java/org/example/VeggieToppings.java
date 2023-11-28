package org.example;

public enum VeggieToppings {
    LETTUCE("Lettuce"),
    PEPPER("Pepper"),
    ONIONS("Onions"),
    TOMATOES("Tomatoes"),
    JALAPENOS("jalapenos"),
    CUCUMBERS("Cucumbers"),
    PICKLES("Pickles"),
    GUACAMOLE("Guacamole"),
    MUSHROOMS("Mushrooms");

    private String displayName;

    private VeggieToppings(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}