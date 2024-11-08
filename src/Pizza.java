import java.util.ArrayList;

public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Curst crust;
    private Size size;
    public abstract double price();
    public Pizza() {}
}
