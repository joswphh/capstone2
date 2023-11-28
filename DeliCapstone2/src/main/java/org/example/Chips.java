package org.example;

public class Chips extends Items {
    private ChipType chipType;

    public Chips(String name, double price, ChipType chipType) {
        super(name, price);
        this.chipType = chipType;
    }

    public ChipType getChipType() {
        return this.chipType;
    }

    public void setChipType(ChipType chipType) {
        this.chipType = chipType;
    }
}
