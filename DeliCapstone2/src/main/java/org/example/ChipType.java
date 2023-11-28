
package org.example;

public enum ChipType {
    BBQ("BQQ", 1.5),
    PLAIN("Plain", 1.5),
    PICKLE("Pickle", 1.5),
    HOT("Hot", 1.5);

    private final String chipType;
    private final double chipPrice;

    private ChipType(String chipType, double chipPrice) {
        this.chipType = chipType;
        this.chipPrice = chipPrice;
    }

    public String getChipType() {
        return this.chipType;
    }

    public double getChipPrice() {
        return this.chipPrice;
    }
}
