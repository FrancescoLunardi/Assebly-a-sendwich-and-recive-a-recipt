import java.util.Scanner;

public class App {
    
    // VARIABILES -----------------------------------------------------------------
    private Scanner scann = new Scanner(System.in);

    
    // List of ingredients:

    // Ingredients that user can adding on his sandwich
    private final static Ingredient[] ingredients = new Ingredient[] {
        
        new Ingredient("Salad", 0.70f, (byte) 0),
        new Ingredient("Tomato", 0.80f, (byte) 0),
        new Ingredient("Ketchup", 0.35f, (byte) 0),
        new Ingredient("Mayonnaise", 0.35f, (byte) 0),
        new Ingredient("Chease", 0.80f, (byte) 0)
    };
    
    // Base ingredients automatically added on every sandwich
    private final static Ingredient[] standardIngredients = new Ingredient[] {
        
        new Ingredient("Hamburger", 2.5f, (byte) 1),
        new Ingredient("Bred slices", 0.75f, (byte) 2) 
    };
    

    // PRIVATE METHODS ------------------------------------------------------------

    private static boolean thereAreTooManyIngredients(Sandwich s) {
        
        final byte maxIngredients = 10;
            
        if (s.getNumberOfIngredients() > maxIngredients) {
            System.out.println("You are arrived at the max number of " + maxIngredients + "!");
            return true;
        }

        return false;
    }


    // Give name and get ingredient obj
    private Ingredient searchIngredientByName(String name) {

        for (Ingredient i : ingredients) {
            if (i.name.toLowerCase().equals(name)) {
                return i;
            }
        }

        return null;
    }
    

    // PUBLIC METHODS -------------------------------------------------------------
    
    static Sandwich newSandwich() {

        return new Sandwich();
    }


    static void printMenu() {

        System.out.println("------------ MENU ------------\n");

        for (Ingredient i : ingredients) {
            System.out.println(i.name + ": " + String.format("%.2f", i.price) + "€");
        }
    }

    
    void addIngredients(Sandwich s) {

        System.out.println("\n------------ ADD INGREDIENTS ------------");
        
        // Adding the base ingredients
        for (Ingredient i : standardIngredients) {
            s.addIngredient(i, i.quantity);
        }
        
        // User can add other ingredinets
        while (true) {
            // Check the number of ingredients in the sandwich
            if (thereAreTooManyIngredients(s)) {
                return;
            }
                        
            // Inizialise values
            String ingredientName = "";
            Byte quantity = 0;

            // Take name
            System.out.print("Ingredient ('S' for stopped): ");
            ingredientName = this.scann.nextLine();
            ingredientName = ingredientName.toLowerCase();

            // Check if the users want stopping
            if (ingredientName.equals("s")) {
                return;
            }

            // Check if the ingredient existe
            
            Ingredient i = this.searchIngredientByName(ingredientName);

            if (i == null) {
                System.out.println("The ingredient unexiste!");
                continue;
            }

            // Take quantity
            System.out.print("Quantity: ");
            quantity = this.scann.nextByte();
            this.scann.nextLine();

            // If the ingredient is was already added, sum only the quantity (not creat a new)
            
            boolean ingredientAlreadyAdded = false;
        
            for (Ingredient sanIng : s.getIngredients()) {
                if (sanIng.name == i.name) {
                    sanIng.changeQuantity((byte) (sanIng.quantity + quantity));
                    System.out.println("---Found quantiti summed");
                    ingredientAlreadyAdded = true;
                }
            }

            if (!ingredientAlreadyAdded) {
                System.out.println("---New element added");
                // Add ingredient
                s.addIngredient(i, quantity);
            }
        }
    }


    
    static void printReceipt(Sandwich s) {

        System.out.println("\n------------ RECEIPT ------------\n");
        System.out.println("Ingredints: ");

        float totalPrice = 0f;

        for (Ingredient i : s.getIngredients()) {
            System.out.println(i.name + " - X" + i.quantity + " - " + String.format("%.2f", i.price) + "€;");
            totalPrice += (i.price * i.quantity);
        }

        System.out.println("\nTotal: " + String.format("%.2f", totalPrice) + "€");
    }
}
