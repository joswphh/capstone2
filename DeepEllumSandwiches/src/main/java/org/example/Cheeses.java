package org.example;

public enum Cheeses {
    AMERICAN("American", .75, 1),
    PROVOLONE("Provolone", .75, 1),
    CHEDDAR("Cheddar", .75, 1),
    SWISS("Swiss", .75, 1),
    EXTRA_CHEESE("Extra cheese", .30, 1);
    private String displayName;
    private final double basePrice;
    private final int priceMultiplier;

    Cheeses(String displayName, double basePrice, int priceMultiplier) {
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.priceMultiplier = priceMultiplier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public double getPrice(SandwichSize size) {
        // Calculate the final price based on the size and multiplier
        return switch (size) {
            case FOUR_INCH -> basePrice * priceMultiplier;
            case EIGHT_INCH -> basePrice * priceMultiplier * 2; // Example: 2 times the base price
            case TWELVE_INCH -> basePrice * priceMultiplier * 3; // Example: 3 times the base price
            default -> basePrice;
        };
    }
}
