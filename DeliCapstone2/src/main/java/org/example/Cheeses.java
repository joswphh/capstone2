package org.example;

public enum Cheeses {
    AMERICAN("American", 0.75, 1),
    PROVOLONE("Provolone", 0.75, 1),
    CHEDDAR("Cheddar", 0.75, 1),
    SWISS("Swiss", 0.75, 1),
    EXTRA_CHEESE("Extra cheese", 0.3, 1);

    private String displayName;
    private final double basePrice;
    private final int priceMultiplier;

    private Cheeses(String displayName, double basePrice, int priceMultiplier) {
        this.displayName = displayName;
        this.basePrice = basePrice;
        this.priceMultiplier = priceMultiplier;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public double getPrice(SandwichSize size) {
        double total;
        switch (size) {
            case FOUR_INCH:
                total = this.basePrice * (double)this.priceMultiplier;
                break;
            case EIGHT_INCH:
                total = this.basePrice * (double)this.priceMultiplier * 2.0;
                break;
            case TWELVE_INCH:
                total = this.basePrice * (double)this.priceMultiplier * 3.0;
                break;
            default:
               total = this.basePrice;
        }

        return total;
    }
}