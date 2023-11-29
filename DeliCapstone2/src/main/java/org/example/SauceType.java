package org.example;

public enum SauceType {
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLAND("Thousand island"),
    VINAIGRETTE("Vinaigrette");

    private String sauce;

    SauceType(String sauce) {
        this.sauce = sauce;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
}