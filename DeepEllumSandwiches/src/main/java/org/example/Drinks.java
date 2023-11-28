package org.example;

public class Drinks extends Items {
    private DrinkType drinkSize;
    private DrinkOptions drinkFlavor;

    public Drinks(String name, double price, DrinkType drinkSize, DrinkOptions drinkFlavor) {
        super(name, price);
        this.drinkSize = drinkSize;
        this.drinkFlavor = drinkFlavor;
    }


    public DrinkType getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkType drinkSize) {
        this.drinkSize = drinkSize;
    }

    public DrinkOptions getDrinkFlavor() {
        return drinkFlavor;
    }

    public void setDrinkFlavor(DrinkOptions drinkFlavor) {
        this.drinkFlavor = drinkFlavor;
    }
}
