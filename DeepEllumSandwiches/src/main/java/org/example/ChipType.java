package org.example;

public enum ChipType {
    BBQ("BQQ", 1.50),
    PLAIN("Plain", 1.50),
    PICKLE("Pickle", 1.50),
    HOT("Hot", 1.50);


    private final String chipType;
    private final double chipPrice;

    ChipType(String chipType, double chipPrice) {
        this.chipType = chipType;
        this.chipPrice = chipPrice;
    }

    public String getChipType() {
        return chipType;
    }

    public double getChipPrice() {
        return chipPrice;
    }
}