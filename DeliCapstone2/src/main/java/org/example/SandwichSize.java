
package org.example;

public enum SandwichSize {
    FOUR_INCH(4, 5.5),
    EIGHT_INCH(8, 7.0),
    TWELVE_INCH(12, 8.5);

    private final int displayName;
    private final double price;

    private SandwichSize(int displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    public int getDisplayName() {
        return this.displayName;
    }

    public double getPrice() {
        return this.price;
    }
}