package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class DeliReceiptWriter {

   /* static void writeReceiptToFile(List<Sandwich> sandwiches) {
        int orderNumber = generateRandomOrderNumber();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/receipt_order_" + orderNumber + ".txt"))) {
            writer.write("Order Details:\n");

            double totalOrderPrice = 0.0;

            for (int i = 0; i < sandwiches.size(); i++) {
                Sandwich sandwich = sandwiches.get(i);

                writer.write("Sandwich #" + (i + 1) + ":\n");
                writer.write("Size: " + sandwich.getSelectedSize() + "\n");

                // Write regular toppings
                writer.write("Regular Toppings:\n");
                for (VeggieToppings topping : sandwich.getSelectedRegularToppings()) {
                    writer.write("- " + topping.getDisplayName() + "\n");
                }

                // Write meat toppings
                writer.write("Meat Toppings:\n");
                for (MeatOptions meat : sandwich.getSelectedMeats()) {
                    writer.write("- " + meat.getDisplayName() + " - $" + meat.getPrice(sandwich.getSelectedSize()) + "\n");
                }

                // Write cheese
                if (sandwich.getSelectedCheese() != null) {
                    writer.write("Cheese: " + sandwich.getSelectedCheese().getDisplayName() + " - $" + sandwich.getSelectedCheese().getPrice(sandwich.getSelectedSize()) + "\n");
                }

                // Write side
                if (sandwich.getSelectedSide() != null) {
                    writer.write("Side: " + sandwich.getSelectedSide().getDisplayName() + "\n");
                }

                // Calculate and write total meat price for the sandwich
                double totalMeatPrice = sandwich.getSelectedMeats().stream()
                        .mapToDouble(meat -> meat.getPrice(sandwich.getSelectedSize()))
                        .sum();
                writer.write("Total Meat Price: $" + totalMeatPrice + "\n");

                // Calculate and accumulate the total order price
                totalOrderPrice += totalMeatPrice + sandwich.getSelectedSize().getPrice();
            }

            // Write the total order price
            writer.write("Total Order Price: $" + totalOrderPrice + "\n");

            System.out.println("Receipt written to receipt.txt");
        } catch (IOException e) {
            System.err.println("Error writing receipt to file: " + e.getMessage());
        }

    }*/

        static void writeReceiptToFile(BreadType breadType, SandwichSize size, List<VeggieToppings> regularToppings,
                                       List<MeatOptions> meats, Cheeses cheese, double totalPrice,
                                       Sides side, boolean isToasted, Chips chips, Drinks drinks) {

            int orderNumber = generateRandomOrderNumber();
            String fileName = "src/main/resources/receipt_order_" + orderNumber + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write("Order Details for Order " + orderNumber + ":\n");

                writer.write("Bread Type: " + breadType + "\n");

                // Write size
                writer.write("Size: " + size + "\n");

                // Write regular toppings
                writer.write("Regular Toppings:\n");
                for (VeggieToppings topping : regularToppings) {
                    writer.write("- " + topping.getDisplayName() + "\n");
                }

                // Write meat toppings
                writer.write("Meat Toppings:\n");
                for (MeatOptions meat : meats) {
                    writer.write("- " + meat.getDisplayName() + " - $" + meat.getPrice(size) + "\n");
                }

                // Write cheese
                if (cheese != null) {
                    writer.write("Cheese: " + cheese.getDisplayName() + " - $" + cheese.getPrice(size) + "\n");
                }

                // Write side
                if (side != null) {
                    writer.write("Side: " + side.getDisplayName() + "\n");
                }

                writer.write("Toasted: " + (isToasted ? "Yes" : "No") + "\n");

                if(chips != null){
                    writer.write("Chips: " + chips.getChipType() + " Price: " + chips.getPrice() + "\n");
                    totalPrice += chips.getPrice();
                }


                if(drinks != null){
                    writer.write(" Drink: " + drinks.getDrinkFlavor() + " Size: " + drinks.getDrinkSize() + " Price: " + drinks.getPrice() + "\n");
                    totalPrice += drinks.getPrice();
                }


                writer.write("Total sandwich Price: $" + totalPrice);

                System.out.println("Receipt written to " + fileName);
            } catch (IOException e) {
                System.err.println("Error writing receipt to file: " + e.getMessage());
            }
        }

    private static int generateRandomOrderNumber() {
        Random random = new Random();
        return 1 + random.nextInt(200);
    }
}
