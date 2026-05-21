import java.util.ArrayList;

public class Sandwich {

    // VARIABILES -----------------------------------------------------------------
    
    // Contains the ingredients of sandwich (base ingredients inclused)
    private ArrayList<Ingredient> ingredients = new ArrayList<>();
    

    // PUBLIC METHODS -------------------------------------------------------------

    void addIngredient(Ingredient i, Byte quantity) {

        i.changeQuantity(quantity);
        ingredients.add(i);
    }
    
    ArrayList<Ingredient> getIngredients() {
        
        return this.ingredients;
    }

    byte getNumberOfIngredients() {

        byte quantity = 0;

        for (Ingredient i : this.ingredients) {
            quantity += i.quantity;
        }

        return quantity;
    }
}
