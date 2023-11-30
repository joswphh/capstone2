package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class DeliReceiptWriter {
        static void writeReceiptToFile(List<Sandwich> sandwiches, List<Chips> chipsList, List<Drinks> drinksList) {
            int orderNumber = generateRandomOrderNumber();
            String fileName = "src/main/resources/receipt_order_" + orderNumber + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write("Order Details for Order " + orderNumber + ":\n");

                // Write sandwich details
                writer.write("Sandwiches:\n");
                for (Sandwich sandwich : sandwiches) {
                    writer.write(sandwich.toString() + "\n");
                }

                // Write chips details
                writer.write("\nChips:\n");
                for (Chips chips : chipsList) {
                    writer.write(chips.toString() + "\n");
                }

                // Write drink details
                writer.write("\nDrinks:\n");
                for (Drinks drinks : drinksList) {
                    writer.write(drinks.toString() + "\n");
                }

                double totalPrice = calculateTotalPrice(sandwiches, chipsList, drinksList);
                writer.write("\nTotal Price: $" + totalPrice);

                System.out.println("Receipt written to " + fileName);
            } catch (IOException e) {
                System.err.println("Error writing receipt to file: " + e.getMessage());
            }
        }

        private static double calculateTotalPrice(List<Sandwich> sandwiches, List<Chips> chipsList, List<Drinks> drinksList) {
            double total = 0;

            // Calculate total price for sandwiches
            for (Sandwich sandwich : sandwiches) {
                total += sandwich.getTotalPrice();
            }

            // Calculate total price for chips
            for (Chips chips : chipsList) {
                total += chips.getPrice();
            }

            // Calculate total price for drinks
            for (Drinks drinks : drinksList) {
                total += drinks.getPrice();
            }

            return total;
        }

        private static int generateRandomOrderNumber() {
            Random random = new Random();
            return 1 + random.nextInt(200);
        }
    }

