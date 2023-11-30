package org.example;

import java.util.List;

public class Sandwich {
    private BreadType breadType;
    private SandwichSize selectedSize;
    private List<VeggieToppings> selectedRegularToppings;
    private List<MeatOptions> selectedMeats;
    private Cheeses selectedCheese;
    private SauceType sauce;
    private double totalPrice;
    private Sides selectedSide;
    private boolean toasted;
    private Chips chips;
    private Drinks drinks;


    public Sandwich(BreadType breadType, SandwichSize selectedSize, List<VeggieToppings> selectedRegularToppings, List<MeatOptions> selectedMeats, Cheeses selectedCheese, SauceType sauce, double totalPrice, Sides selectedSide, boolean toasted, Chips chips, Drinks drinks) {
        this.breadType = breadType;
        this.selectedSize = selectedSize;
        this.selectedRegularToppings = selectedRegularToppings;
        this.selectedMeats = selectedMeats;
        this.selectedCheese = selectedCheese;
        this.sauce = sauce;
        this.totalPrice = totalPrice;
        this.selectedSide = selectedSide;
        this.toasted = toasted;
        this.chips = chips;
        this.drinks = drinks;

    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public SandwichSize getSelectedSize() {
        return selectedSize;
    }

    public void setSelectedSize(SandwichSize selectedSize) {
        this.selectedSize = selectedSize;
    }

    public List<VeggieToppings> getSelectedRegularToppings() {
        return selectedRegularToppings;
    }

    public void setSelectedRegularToppings(List<VeggieToppings> selectedRegularToppings) {
        this.selectedRegularToppings = selectedRegularToppings;
    }

    public List<MeatOptions> getSelectedMeats() {
        return selectedMeats;
    }

    public void setSelectedMeats(List<MeatOptions> selectedMeats) {
        this.selectedMeats = selectedMeats;
    }

    public Cheeses getSelectedCheese() {
        return selectedCheese;
    }

    public void setSelectedCheese(Cheeses selectedCheese) {
        this.selectedCheese = selectedCheese;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Sides getSelectedSide() {
        return selectedSide;
    }

    public void setSelectedSide(Sides selectedSide) {
        this.selectedSide = selectedSide;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public SauceType getSauce() {
        return sauce;
    }

    public void setSauce(SauceType sauce) {
        this.sauce = sauce;
    }

    public void setDrinks(Drinks drinks) {
        this.drinks = drinks;
    }
    @Override
    public String toString() {
        return "Bread: " + breadType + "\n" +
                "Size: " + selectedSize + "\n" +
                "Regular Toppings: " + selectedRegularToppings + "\n" +
                "Meats: " + selectedMeats + "\n" +
                "Cheese: " + selectedCheese + "\n" +
                "Sauce: " + sauce + "\n" +
                "Toasted: " + toasted + "\n" +
                "Total Price: $" + totalPrice + "\n";
    }

}