package org.example;

import java.util.List;

public class Sandwich {
    private BreadType breadType;
    private SandwichSize selectedSize;
    private List<VeggieToppings> selectedRegularToppings;
    private List<MeatOptions> selectedMeats;
    private Cheeses selectedCheese;
    private double totalPrice;
    private Sides selectedSide;
    private boolean toasted;


    public Sandwich(BreadType breadType, SandwichSize selectedSize, List<VeggieToppings> selectedRegularToppings, List<MeatOptions> selectedMeats, Cheeses selectedCheese, double totalPrice, Sides selectedSide, boolean toasted) {
        this.breadType = breadType;
        this.selectedSize = selectedSize;
        this.selectedRegularToppings = selectedRegularToppings;
        this.selectedMeats = selectedMeats;
        this.selectedCheese = selectedCheese;
        this.totalPrice = totalPrice;
        this.selectedSide = selectedSide;
        this.toasted = toasted;
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

    private Sandwich processAddSandwich() {
        // Your existing code for adding a sandwich
        // ...

        Sandwich newSandwich = new Sandwich(getBreadType(), getSelectedSize(),getSelectedRegularToppings(),getSelectedMeats(),
                getSelectedCheese(),getTotalPrice(),getSelectedSide(),isToasted());
        // Set properties of newSandwich based on user input

        return newSandwich;
    }
}