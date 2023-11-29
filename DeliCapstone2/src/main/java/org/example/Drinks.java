package org.example;

public class Drinks{
    private double price;
    private DrinkType drinkSize;
    private DrinkOptions drinkFlavor;

    public Drinks(double price, DrinkType drinkSize, DrinkOptions drinkFlavor) {
        this.price = price;
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public DrinkType getDrinkSize() {
        return this.drinkSize;
    }

    public void setDrinkSize(DrinkType drinkSize) {
        this.drinkSize = drinkSize;
    }

    public DrinkOptions getDrinkFlavor() {
        return this.drinkFlavor;
    }

    public void setDrinkFlavor(DrinkOptions drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
    }

    @Override
    public String toString() {
        return "Flavor: " + drinkFlavor + "\n" +
                "Size: " + drinkSize + "\n" +
                "Price: $" + price;
    }
}