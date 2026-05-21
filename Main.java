public class Main {
    public static void main(String[] args) throws Exception {
        
        App main = new App();            // Create the main obj
        Sandwich s = main.newSandwich(); // Create the sandiwich
        
        main.printMenu();;
        main.addIngredients(s);
        main.printReceipt(s);
    }
}
