package org.example;

import java.util.ArrayList;

public class Toppings {
    private ArrayList<MeatOptions> meats;
    private ArrayList<SauceType> sauce;
    private ArrayList<Sides> sides;
    private ArrayList<VeggieToppings> toppings;
    private ArrayList<Cheeses> cheeses;

    public Toppings(ArrayList<MeatOptions> meats, ArrayList<SauceType> sauce, ArrayList<Sides> sides, ArrayList<VeggieToppings> toppings, ArrayList<Cheeses> cheeses) {
        this.meats = meats;
        this.sauce = sauce;
        this.sides = sides;
        this.toppings = toppings;
        this.cheeses = cheeses;
    }

    public ArrayList<MeatOptions> getMeats() {
        return meats;
    }

    public void setMeats(ArrayList<MeatOptions> meats) {
        this.meats = meats;
    }

    public ArrayList<SauceType> getSauce() {
        return sauce;
    }

    public void setSauce(ArrayList<SauceType> sauce) {
        this.sauce = sauce;
    }

    public ArrayList<Sides> getSides() {
        return sides;
    }

    public void setSides(ArrayList<Sides> sides) {
        this.sides = sides;
    }

    public ArrayList<VeggieToppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<VeggieToppings> toppings) {
        this.toppings = toppings;
    }

    public ArrayList<Cheeses> getCheeses() {
        return cheeses;
    }

    public void setCheeses(ArrayList<Cheeses> cheeses) {
        this.cheeses = cheeses;
    }

    public void addMeats(ArrayList<MeatOptions> meats){
        meats.add(MeatOptions.STEAK);
        meats.add(MeatOptions.HAM);
        meats.add(MeatOptions.SALAMI);
        meats.add(MeatOptions.ROAST_BEEF);
        meats.add(MeatOptions.CHICKEN);
        meats.add(MeatOptions.BACON);
        meats.add(MeatOptions.EXTRA_MEAT);
    }

    public void addCheese(ArrayList<Cheeses> cheeses){
        cheeses.add(Cheeses.AMERICAN);
        cheeses.add(Cheeses.PROVOLONE);
        cheeses.add(Cheeses.CHEDDAR);
        cheeses.add(Cheeses.SWISS);
        cheeses.add(Cheeses.EXTRA_CHEESE);
    }

    private void addToppings(ArrayList<VeggieToppings> toppings){
        toppings.add(VeggieToppings.LETTUCE);
        toppings.add(VeggieToppings.PEPPER);
        toppings.add(VeggieToppings.ONIONS);
        toppings.add(VeggieToppings.TOMATOES);
        toppings.add(VeggieToppings.JALAPENOS);
        toppings.add(VeggieToppings.CUCUMBERS);
        toppings.add(VeggieToppings.PICKLES);
        toppings.add(VeggieToppings.GUACAMOLE);
        toppings.add(VeggieToppings.MUSHROOMS);
    }

    private void addSauce(ArrayList<SauceType> sauce){
        sauce.add(SauceType.MAYO);
        sauce.add(SauceType.MUSTARD);
        sauce.add(SauceType.KETCHUP);
        sauce.add(SauceType.RANCH);
        sauce.add(SauceType.THOUSAND_ISLAND);
        sauce.add(SauceType.VINAIGRETTE);
    }

    private void addSide(ArrayList<Sides> sides){
        sides.add(Sides.AU_JUS);
        sides.add(Sides.CHIPOTLE);
    }

}
