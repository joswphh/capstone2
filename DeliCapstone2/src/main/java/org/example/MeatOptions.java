package org.example;

public enum MeatOptions {
    EXTRA_MEAT("Extra meat", 0.5, 1),
    STEAK("Steak", 1.0, 1),
    HAM("Ham", 1.0, 1),
    SALAMI("Salami", 1.0, 1),
    ROAST_BEEF("Roast beef", 1.0, 1),
    BACON("Bacon", 1.0, 1),
    CHICKEN("Chicken", 1.0, 1);

    private String displayName;
    private double basePrice;
    private int priceMultiplier;

    private MeatOptions(String displayName, double basePrice, int priceMultiplier) {
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
