package org.example;

public class chips extends Items {
    private ChipType chipType;

    public chips(String name, double price, ChipType chipType) {
        super(name, price);
        this.chipType = chipType;
    }

    public ChipType getChipType() {
        return chipType;
    }

    public void setChipType(ChipType chipType) {
        this.chipType = chipType;
    }
}
