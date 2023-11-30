
package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BLT extends Sandwich{
    private static final BreadType BLT_BREAD_TYPE = BreadType.WHITE;
    private static final SandwichSize BLT_SIZE = SandwichSize.EIGHT_INCH;
    private static final List<VeggieToppings> BLT_REGULAR_TOPPINGS = new ArrayList<>(Arrays.asList(VeggieToppings.LETTUCE, VeggieToppings.TOMATOES));

    private static final List<MeatOptions> BLT_MEATS = List.of(MeatOptions.BACON);
    private static final Cheeses BLT_CHEESE = Cheeses.CHEDDAR;
    private static final SauceType BLT_SAUCE = SauceType.RANCH;
    private static final double BLT_TOTAL_PRICE = 11.00;
    private static final Sides BLT_SIDE = null;
    private static final boolean BLT_TOASTED = true;
    private static final Chips BLT_CHIPS = null;
    private static final Drinks BLT_DRINK = null;

    // Constructor using the preset values
    public BLT() {
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
