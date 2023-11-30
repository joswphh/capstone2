
package org.example;

import java.util.*;

import static org.example.DeliReceiptWriter.writeReceiptToFile;

public class UserInterface {
    Scanner scanner;
    private BreadType selectedBread;
    private SandwichSize selectedSize;
    private List<VeggieToppings> selectedRegularToppings;
    private List<MeatOptions> selectedMeats;
    private Cheeses selectedCheese;
    private SauceType sauce;
    private double totalPrice;
    private Sides selectedSide;
    private boolean toasted;
    private Chips chips;
    private Drinks drink;
    List<Sandwich> sandwiches = new ArrayList<>(); // Track multiple sandwiches
    List<Chips> chipsList = new ArrayList<>(); // Track multiple chips
    List<Drinks> drinksList = new ArrayList<>(); // Track multiple drinks
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        boolean isRunning = true;
        new Scanner(System.in);

        while(isRunning) {
            System.out.println("Welcome to Deep Ellum Sandwiches! What would you like to do?");
            System.out.println("1) Make a new Order");
            System.out.println("0) Exit");
            Scanner banner = new Scanner(System.in);
            int userInput = banner.nextInt();
            switch (userInput) {
                case 1:
                    this.processMakeNewOrder();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    System.exit(0);
                    break;
            }
        }

    }

    private void processMakeNewOrder() {
        boolean isRunning = true;

        while(isRunning) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Here is the order screen! Select a number");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Preset sandwich");
            System.out.println("3) Add Drink");
            System.out.println("4) Add Chips");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 0:
                    System.out.println("You have canceled your order! We will go back to the home screen!");
                    isRunning = false;
                    break;
                case 1:
                    processAddSandwich();
                    break;
                case 2:
                    processPresetSandwich();
                    break;
                case 3:
                    this.processAddDrink();
                    break;
                case 4:
                    this.processAddChips();
                    break;
                case 5:
                    this.processCheckout();
                default:
                    System.out.println("Invalid option. select numbers 0-5.");
            }
        }

    }

    private Sandwich processAddSandwich() {
        System.out.println("Select your bread:");

        for (BreadType bread : BreadType.values()) {
            System.out.println(bread.ordinal()+1  + ": " + bread);
        }

        int breadChoice = scanner.nextInt();

        this.selectedBread = BreadType.values()[breadChoice - 1];

        System.out.println("Select your size:");

        // Iterate over each size option and display it to the user
        for (int i = 0; i < SandwichSize.values().length; i++) {
            SandwichSize size = SandwichSize.values()[i];
            System.out.println(i + 1 + ") " + size.getDisplayName() + " - $" + size.getPrice());
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
        this.selectedSize = SandwichSize.values()[sizeChoice - 1];

        System.out.println("You selected size: " + selectedSize.getDisplayName());
        System.out.println("Price: $" + selectedSize.getPrice());

        scanner.nextLine();

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Would you like your bread toasted? (Yes/No)");
            String isToasted = scanner.nextLine().toLowerCase();

            if ("yes".equals(isToasted)) {
                this.toasted = true;
                validInput = true; // Exit the loop if the input is valid
            } else if ("no".equals(isToasted)) {
                this.toasted = false;
                validInput = true; // Exit the loop if the input is valid
            } else {
                System.out.println("Invalid option. Please enter (Yes/No).");
            }
        }


        System.out.println("Select your meat toppings (enter 0 to finish): ");

        List<MeatOptions> availableMeats = new ArrayList<>(Arrays.asList(MeatOptions.values()));


        availableMeats.sort(Comparator.comparingDouble(meat -> meat.getPrice(selectedSize)));

        // Display the sorted meat toppings
        for (MeatOptions meat : availableMeats) {
            System.out.println(meat.ordinal()+1 + ") " + meat.getDisplayName() + " - $" + meat.getPrice(selectedSize));
        }

        // Read the user's choice for meat toppings
        int meatChoice;
        this.selectedMeats = new ArrayList<>();
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

        // Calculate the total price for selected meat toppings
        double totalMeatPrice = selectedMeats.stream().mapToDouble(meat -> meat.getPrice(selectedSize)).sum();

        // Display the selected meat toppings and their prices
        System.out.println("You selected the following meat toppings:");
        for (MeatOptions meat : selectedMeats) {
            System.out.println(meat.getDisplayName() + " - $" + meat.getPrice(selectedSize));
        }

        // Display the total price for meat toppings
        System.out.println("Total Meat Price: $" + totalMeatPrice);




        System.out.println("Select your regular toppings (enter 0 to finish): ");

        this.selectedRegularToppings = new ArrayList<>();

        // Iterate over each regular toppings option and display it to the user
        for (int i = 0; i < VeggieToppings.values().length; i++) {
            System.out.println(i + 1 + ") " + VeggieToppings.values()[i]);
        }

        // Allow the user to select multiple toppings
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
            }
        } while (regularToppingsChoice != 0);

        // Display the selected regular toppings
        System.out.println("You selected the following regular toppings: " + selectedRegularToppings);

        System.out.println("Select your cheese (enter 0 to skip): ");

        for (int i = 0; i < Cheeses.values().length; i++) {
            Cheeses cheese = Cheeses.values()[i];
            System.out.println(i + 1 + ") " + cheese.getDisplayName() + " - $" + cheese.getPrice(selectedSize));
        }

// Read the user's choice for cheese
        int cheeseChoice;
        this.selectedCheese = null;
        do {
            System.out.print("Enter the number corresponding to your choice of cheese (enter 0 to skip): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            cheeseChoice = scanner.nextInt();

            if (cheeseChoice >= 1 && cheeseChoice <= Cheeses.values().length) {
                selectedCheese = Cheeses.values()[cheeseChoice - 1];
            }
        } while (cheeseChoice != 0);

// Display the selected cheese and its price
        if (selectedCheese != null) {
            System.out.println("You selected cheese: " + selectedCheese.getDisplayName());
            System.out.println("Price: $" + selectedCheese.getPrice(selectedSize));
        }

// Calculate the total price for selected cheese
        double totalCheesePrice = (selectedCheese != null) ? selectedCheese.getPrice(selectedSize) : 0.0;

        for (int i = 0; i < SauceType.values().length; i++) {
            SauceType sauces = SauceType.values()[i];
            System.out.println(i + 1 + ") " + sauces.getSauce());
        }

        int sauceSelected;
        this.sauce = null;
        do {
            System.out.println("Select your sauces (enter 0 to finish): ");
            while(!scanner.hasNextInt()){
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            sauceSelected = scanner.nextInt();
            if (sauceSelected >= 1 && sauceSelected <= SauceType.values().length) {
                sauce = SauceType.values()[sauceSelected - 1];
            }
        } while (sauceSelected != 0);

        if (sauce != null) {
            System.out.println("You selected sauce: " + sauce.getSauce());
        }

        System.out.println("Select your side (enter 0 to skip): ");

        for (int i = 0; i < Sides.values().length; i++) {
            Sides side = Sides.values()[i];
            System.out.println(i + 1 + ") " + side.getDisplayName());
        }

        // Read the user's choice for a side
        int sideChoice;
        this.selectedSide = null;
        do {
            System.out.print("Enter the number corresponding to your choice of side (enter 0 to skip): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }
            sideChoice = scanner.nextInt();

            if (sideChoice >= 1 && sideChoice <= Sides.values().length) {
                selectedSide = Sides.values()[sideChoice - 1];
            }
        } while (sideChoice != 0);

        this.totalPrice = totalCheesePrice + totalMeatPrice + selectedSize.getPrice();
        Sandwich sandwich = new Sandwich(selectedBread, selectedSize, selectedRegularToppings, selectedMeats, selectedCheese, sauce, totalPrice, selectedSide, toasted, chips, drink);
        sandwiches.add(sandwich); // Add the created sandwich to the list

        return null;
    }

    private void processAddDrink() {
        Scanner scanner = new Scanner(System.in);

        double drinkPrice = 0;

        DrinkOptions drinkFlavor = null;
        DrinkType size = null;
        int sizeCount = 1;
        int flavorCount = 1;

        ArrayList<DrinkOptions> drinkInventory = new ArrayList<>();
        drinkInventory.addAll(Arrays.asList(DrinkOptions.values()));
        Collections.sort(drinkInventory);


        ArrayList<DrinkType> drinkSizes = new ArrayList<>();
        drinkSizes.addAll(Arrays.asList(DrinkType.values()));
        Collections.sort(drinkSizes);

        System.out.println("Select your cup size: (Number) ");

        for (DrinkType drinkDrinkSizes : drinkSizes) {
            System.out.println(sizeCount + ") " + drinkDrinkSizes.name());
            sizeCount++;
        }

        int drinkSizeChoice = scanner.nextInt();

        if (drinkSizeChoice == 1) {
            size = DrinkType.SMALL;
            drinkPrice = 2.00;
        } else if (drinkSizeChoice == 2) {
            size = DrinkType.MEDIUM;
            drinkPrice = 2.50;
        } else if (drinkSizeChoice == 3) {
            size = DrinkType.LARGE;
            drinkPrice = 3.00;
        }

        System.out.println("Type your drink name:");

        for (DrinkOptions flavors : drinkInventory) {
            System.out.println(flavorCount + ") " + flavors.name());
            flavorCount++;
        }

        scanner.nextLine();
        String userChoice = scanner.nextLine();

        drinkFlavor = switch (userChoice) {
            case "1" -> DrinkOptions.SPRITE;
            case "2" -> DrinkOptions.ROOT_BEER;
            case "3" -> DrinkOptions.WATER;
            case "4" -> DrinkOptions.COCA_COLA;
            default -> {
                System.out.println("Wrong input. PLease try again.");
                yield null;
            }
        };

        Drinks drinks = new Drinks(drinkPrice, size, drinkFlavor);
        // public Drinks(String name, double price, DrinkType drinkSize, DrinkOptions drinkFlavor) {
        this.drink = drinks;
        drinksList.add(drinks); // Add the created drink to the list

        System.out.println("Your " + drinkFlavor + " drink has successfully been added to your order!");

    }

       /* flavorChoice = switch (userChoice) {
            case "SPRITE" -> DrinkOptions.SPRITE;
            case "ROOT_BEER" -> DrinkOptions.ROOT_BEER;
            case "WATER" -> DrinkOptions.WATER;
            case "COCA_COLA" -> DrinkOptions.COCA_COLA;
            default -> flavorChoice;
        };

        */


    private void processAddChips() {
        Scanner scanner = new Scanner(System.in);

        ChipType chipFlavors = null;
        int count = 1;

         ArrayList<ChipType> chipInventory = new ArrayList<>();
        chipInventory.addAll(Arrays.asList(ChipType.values()));
        Collections.sort(chipInventory);


        System.out.println("Choose your chips! Select a number ");

        for (ChipType myChips : chipInventory) {

            System.out.println(count + ") " + myChips.name() + ": " + myChips.getChipPrice());
            count++;
        }

        String userChoice = scanner.nextLine();

        chipFlavors = switch (userChoice) {
            case "1" -> ChipType.BBQ;
            case "2" -> ChipType.PLAIN;
            case "3" -> ChipType.PICKLE;
            case "4" -> ChipType.HOT;
            default -> chipFlavors;
        };

        this.chips = new Chips(userChoice, 1.50, chipFlavors);
        chipsList.add(chips); // Add the created chips to the list

        System.out.println("Your " + chipFlavors + " chips has successfully been added to your order!");

    }

    private void processCheckout() {
        boolean isCheckingOut = true;
        Scanner scan = new Scanner(System.in);

        while (isCheckingOut) {

            System.out.println("Would you like to proceed with checkout? Y/N");
            String selection = scan.nextLine().toUpperCase();

            switch (selection) {
                case "Y":
                    isCheckingOut = false;
                    System.out.println("How would you like to pay?");
                    System.out.println("1) Cash");
                    System.out.println("2) Debit");
                    int paymentMethod = scan.nextInt();

                    if (paymentMethod == 1) {
                        System.out.println("Thank You for ordering!");
                    } else if (paymentMethod == 2) {
                        System.out.println("1) Swipe, 2) Insert, or 3) Tap your card");
                        int payFunction = scan.nextInt();
                        if (payFunction == 3) {
                            System.out.println("Approved!\n");
                            System.out.println("Thank You for ordering from D!");
                        } else {
                            System.out.println("Enter your pin");
                            int pin = scan.nextInt();
                            System.out.println("Approved!\n");
                            System.out.println("Thank You for ordering!");
                        }
                    } else {
                        System.out.println("Please enter a valid selection.");
                    }
                    writeReceiptToFile(sandwiches, chipsList, drinksList);
                    sandwiches.clear();
                    chipsList.clear();
                    drinksList.clear();

                    break;
                case "N":
                    // Loop back into checkout start
                    isCheckingOut = false;
                    break;
                default:
                    System.out.println("Please enter a valid selection");
            }
        }
    }

    public void processPresetSandwich(){
        boolean presetLoop = true;

        while(presetLoop){
            System.out.println("---You are choosing from preset sandwiches---");
            System.out.println("Please select one of the following");
            System.out.println("-------------------------------------");
            System.out.println("1) BLT  preset sandwich");
            System.out.println("2) Philly cheese steak  preset sandwich");
            System.out.println("3) go back to main menu");
            int presetChoice = 0;
            
            if(scanner.hasNextInt()){
                presetChoice = scanner.nextInt();
            }else {
                System.out.println("Invalid input. PLease enter a number 1-3.");
            }
            switch(presetChoice){
                case 1:
                    addBLT();
                    break;
                case 2:
                    addPhillyCheeseSteak();
                    break;
                case 3:
                    presetLoop = false;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    public void addBLT(){
        BLT blt = new BLT();
        List<VeggieToppings> availableToppings = new ArrayList<>(Arrays.asList(VeggieToppings.values()));

        // Display the current state of the BLT sandwich
        System.out.println("Current state of BLT sandwich:");
        System.out.println(blt.toString());
        boolean modifyToppings = true;

        while (modifyToppings) {
            System.out.println("1) Add Toppings");
            System.out.println("2) Remove Toppings");
            System.out.println("0) Done");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 0:
                    // User is done modifying toppings
                    modifyToppings = false;
                    break;
                case 1:
                    // Display available toppings
                    System.out.println("Available toppings:");
                    for (VeggieToppings topping : VeggieToppings.values()) {
                        System.out.println(topping.ordinal() + 1 + ": " + topping);
                    }

                    // Prompt the user to add toppings
                    System.out.println("Enter the number corresponding to the topping you want to add (enter 0 to finish): ");
                    int toppingChoice;
                    do {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // consume the invalid input
                        }
                        toppingChoice = scanner.nextInt();

                        if (toppingChoice >= 1 && toppingChoice <= availableToppings.size()) {
                            blt.addToppings(availableToppings.get(toppingChoice - 1));
                            System.out.println("You selected the following regular toppings (press 0 to exit): " + toppingChoice);
                        }
                    } while (toppingChoice != 0);

                    break;

                case 2:
                    // Display current toppings
                    System.out.println("Current toppings:");
                    for (VeggieToppings topping : blt.getSelectedRegularToppings()) {
                        System.out.println(topping.ordinal() + 1 + ": " + topping);
                    }

                    // Prompt the user to remove toppings
                    System.out.println("Enter the number corresponding to the topping you want to remove (enter 0 to finish): ");
                    int removeChoice;
                    do {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // consume the invalid input
                        }
                        removeChoice = scanner.nextInt();

                        if (removeChoice >= 1 && removeChoice <= availableToppings.size()) {
                            blt.removeToppings(availableToppings.get(removeChoice - 1));
                            System.out.println("You removed the following regular toppings (press 0 to exit): " + removeChoice);

                        }
                    } while (removeChoice != 0);

                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        sandwiches.add(blt);
        // Display the final state of the BLT sandwich after modifications
        System.out.println("Final state of BLT sandwich:");
        System.out.println(blt.toString());

        scanner.nextLine();
    }


    public void addPhillyCheeseSteak(){
        PhillyCheeseSteak philly = new PhillyCheeseSteak();
        List<VeggieToppings> availableToppings = new ArrayList<>(Arrays.asList(VeggieToppings.values()));

        // Display the current state of the BLT sandwich
        System.out.println("Current state of BLT sandwich:");
        System.out.println(philly.toString());
        boolean modifyToppings = true;


        while (modifyToppings) {
            System.out.println("1) Add Toppings");
            System.out.println("2) Remove Toppings");
            System.out.println("0) Done");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 0:
                    // User is done modifying toppings
                    modifyToppings = false;
                    break;
                case 1:
                    // Display available toppings
                    System.out.println("Available toppings:");
                    for (VeggieToppings topping : VeggieToppings.values()) {
                        System.out.println(topping.ordinal() + 1 + ": " + topping);
                    }

                    // Prompt the user to add toppings
                    System.out.println("Enter the number corresponding to the topping you want to add (enter 0 to finish): ");
                    int toppingChoice;
                    do {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // consume the invalid input
                        }
                        toppingChoice = scanner.nextInt();

                        if (toppingChoice >= 1 && toppingChoice <= availableToppings.size()) {
                            philly.addToppings(availableToppings.get(toppingChoice - 1));
                            System.out.println("You selected the following regular toppings (press 0 to exit): " + toppingChoice);
                        }
                    } while (toppingChoice != 0);

                    break;

                case 2:
                    // Display current toppings
                    System.out.println("Current toppings:");
                    for (VeggieToppings topping : philly.getSelectedRegularToppings()) {
                        System.out.println(topping.ordinal() + 1 + ": " + topping);
                    }

                    // Prompt the user to remove toppings
                    System.out.println("Enter the number corresponding to the topping you want to remove (enter 0 to finish): ");
                    int removeChoice;
                    do {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // consume the invalid input
                        }
                        removeChoice = scanner.nextInt();

                        if (removeChoice >= 1 && removeChoice <= availableToppings.size()) {
                            philly.removeToppings(availableToppings.get(removeChoice - 1));
                            System.out.println("You removed the following regular toppings (press 0 to exit): " + removeChoice);

                        }
                    } while (removeChoice != 0);

                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        sandwiches.add(philly);
        // Display the final state of the BLT sandwich after modifications
        System.out.println("Final state of BLT sandwich:");
        System.out.println(philly.toString());
    }
}
