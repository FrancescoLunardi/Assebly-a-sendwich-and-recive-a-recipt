public class Ingredient {

    // VARIABILES -----------------------------------------------------------------

    String name = "";
    float price = 0.00f;
    byte quantity = 0;

    // PUBLIC METHODS -------------------------------------------------------------


    Ingredient(String name, float price, byte quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void changeQuantity(byte quantity) {
        this.quantity = quantity;
    }
}
