
package org.example;

import java.util.Arrays;
import java.util.List;

public class PhillyCheeseSteak extends Sandwich {
    private static final BreadType BLT_BREAD_TYPE = BreadType.WHITE;
    private static final SandwichSize BLT_SIZE = SandwichSize.EIGHT_INCH;
    private static final List<VeggieToppings> BLT_REGULAR_TOPPINGS = List.of(VeggieToppings.PEPPER);
    private static final List<MeatOptions> BLT_MEATS = List.of(MeatOptions.STEAK);
    private static final Cheeses BLT_CHEESE = Cheeses.AMERICAN;
    private static final SauceType BLT_SAUCE = SauceType.MAYO;
    private static final double BLT_TOTAL_PRICE = 0.0; // Set the correct total price based on your pricing logic
    private static final Sides BLT_SIDE = null;
    private static final boolean BLT_TOASTED = true; // BLT is not toasted
    private static final Chips BLT_CHIPS = null; // BLT doesn't come with chips
    private static final Drinks BLT_DRINK = null; // BLT doesn't come with a drink

    // Constructor using the preset values
    public PhillyCheeseSteak() {
        super(BLT_BREAD_TYPE, BLT_SIZE, BLT_REGULAR_TOPPINGS, BLT_MEATS, BLT_CHEESE, BLT_SAUCE, BLT_TOTAL_PRICE, BLT_SIDE, BLT_TOASTED, BLT_CHIPS, BLT_DRINK);
    }

    // Add toppings to the BLT
    public void addToppings(VeggieToppings... toppings) {
        this.getSelectedRegularToppings().addAll(Arrays.asList(toppings));
    }

    // Remove toppings from the BLT
    public void removeToppings(VeggieToppings... toppings) {
        this.getSelectedRegularToppings().removeAll(Arrays.asList(toppings));
    }
}
