package org.example;

public enum SandwichSize {
    FOUR_INCH(4, 5.50),
    EIGHT_INCH(8, 7.00),
    TWELVE_INCH(12, 8.50);

    private final int displayName;
    private final double price;

    SandwichSize(int displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    public int getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }


}
