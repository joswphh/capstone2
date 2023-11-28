package org.example;

import java.util.List;

public class Sandwich {
    private BreadType bread;
    private List<String> topping;
    private SandwichSize size;
    private List<String> sauces;
    private List<String> sides;
    private boolean isToasted;

    public Sandwich(BreadType bread, List<String> topping, SandwichSize size, List<String> sauces, List<String> sides, boolean isToasted) {
        this.bread = bread;
        this.topping = topping;
        this.size = size;
        this.sauces = sauces;
        this.sides = sides;
        this.isToasted = isToasted;
    }

    public BreadType getBread() {
        return this.bread;
    }

    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public List<String> getTopping() {
        return this.topping;
    }

    public void setTopping(List<String> topping) {
        this.topping = topping;
    }

    public SandwichSize getSize() {
        return this.size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public List<String> getSauces() {
        return this.sauces;
    }

    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    public List<String> getSides() {
        return this.sides;
    }

    public void setSides(List<String> sides) {
        this.sides = sides;
    }

    public boolean isToasted() {
        return this.isToasted;
    }

    public void setToasted(boolean toasted) {
        this.isToasted = toasted;
    }
}

