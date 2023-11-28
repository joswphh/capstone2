package org.example;

public enum MeatOptions {
    EXTRA_MEAT("Extra meat", .50, 1),
    STEAK("Steak", 1, 1),
    HAM("Ham", 1, 1),
    SALAMI("Salami", 1, 1),
    ROAST_BEEF("Roast beef", 1, 1),
    BACON("Bacon", 1, 1),
    CHICKEN("Chicken", 1, 1);
    private String displayName;
    private double basePrice;
    private int priceMultiplier;

    MeatOptions(String displayName, double basePrice, int priceMultiplier) {
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
