package org.example;

import java.util.*;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    public void display() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.println("Welcome to Deep Ellum Sandwiches! What would you like to do?");
            System.out.println("1) Make a new Order");
            System.out.println("0) Exit");

            Scanner banner = new Scanner(System.in);
            int userInput = banner.nextInt();

            switch (userInput) {
                case 1:
                    //make a new order
                    processMakeNewOrder();


                case 0:
                    System.exit(0);
                    break;

            }

            }
        }

    private void processMakeNewOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here is the order screen! Select a number");
        System.out.println("1) Add Sandwich");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Chips");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");

        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                processAddSandwich();
                break;
            case 2:
                processAddDrink();
                break;
            case 3:
                processAddChips();
                break;
            case 4:
                processCheckout();
                break;
            case 0:
                System.out.println("You have canceled your order! We will go back to the home screen!");
                break;


        }
    }

    private void processAddSandwich() {
        System.out.println("Building a sandwich!");

        System.out.println("What type of bread would you like?");
        for(BreadType bread : BreadType.values()){
            System.out.println(bread.ordinal()+1 + ":" + bread);
        }
        int breadChoice = scanner.nextInt();

        System.out.println("Select your size:");

        // Iterate over each size option and display it to the user
        for (int i = 0; i < SandwichSize.values().length; i++) {
            SandwichSize size = SandwichSize.values()[i];
            System.out.println(i + 1 + ": " + size.getDisplayName() + " - $" + size.getPrice());
        }

        // Read the user's choice for the size
        int sizeChoice;
        do {
            System.out.print("Enter the number corresponding to your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            sizeChoice = scanner.nextInt();
        } while (sizeChoice < 1 || sizeChoice > SandwichSize.values().length);

        // Get the corresponding size value based on the user's choice
        SandwichSize selectedSize = SandwichSize.values()[sizeChoice - 1];

        System.out.println("You selected size: " + selectedSize.getDisplayName());
        System.out.println("Price: $" + selectedSize.getPrice());

        scanner.nextLine();

        System.out.println("Would you like this toasted (Yes/No)");
        String isToasted = scanner.nextLine();
        boolean toasted = Boolean.parseBoolean(isToasted);


        System.out.println("Select your meat toppings (enter 0 to finish): ");

        List<MeatOptions> availableMeats = Arrays.asList(MeatOptions.values());

        // Sort meats based on price
        availableMeats.sort(Comparator.comparingDouble(meat -> meat.getPrice(selectedSize)));

        // Display the sorted meat toppings
        for (MeatOptions meat : availableMeats) {
            System.out.println(meat.ordinal()+1 +": " + meat.getDisplayName() + " - $" + meat.getPrice(selectedSize));
        }

        int meatChoice;
        List<MeatOptions> selectedMeats = new ArrayList<>();
        do {
            System.out.print("Enter the number corresponding to your choice (enter 0 to finish): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            meatChoice = scanner.nextInt();

            if (meatChoice >= 1 && meatChoice <= availableMeats.size()) {
                selectedMeats.add(availableMeats.get(meatChoice - 1));
            }
        } while (meatChoice != 0);

        double totalMeatPrice = selectedMeats.stream().mapToDouble(meat -> meat.getPrice(selectedSize)).sum();

        // Display the selected meat toppings and their prices
        System.out.println("You selected the following meat toppings:");
        for (MeatOptions meat : selectedMeats) {
            System.out.println(meat.getDisplayName() + " - $" + meat.getPrice(selectedSize));
        }

         System.out.println("Select your regular toppings (enter 0 to finish): ");

        List<VeggieToppings> selectedRegularToppings = new ArrayList<>();
        // Iterate over each regular toppings option and display it to the user
        for (int i = 0; i < VeggieToppings.values().length; i++) {
            VeggieToppings topping = VeggieToppings.values()[i];
            System.out.println(i + 1 + ") " + topping.getDisplayName());
        }

        // Read the user's choice for regular toppings
        int regularToppingsChoice;
        do {
            System.out.print("Enter the number corresponding to your choice (enter 0 to finish): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            regularToppingsChoice = scanner.nextInt();

            if (regularToppingsChoice >= 1 && regularToppingsChoice <= VeggieToppings.values().length) {
                selectedRegularToppings.add(VeggieToppings.values()[regularToppingsChoice - 1]);
                System.out.println();
            }
        } while (regularToppingsChoice != 0);

        System.out.println("You selected the following toppings:");
        for (VeggieToppings toppings : selectedRegularToppings){
            System.out.println(toppings.getDisplayName());
        }



    }


    private void processAddDrink() {

    }

    private void processAddChips() {

    }

    private void processCheckout() {

    }

}
