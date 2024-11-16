package Pizza;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PizzaAndPrice {
    private ArrayList<Topping> toppings;
    private Curst crust;
    private Size size;
    private double price;
    public PizzaAndPrice( Pizza pizza, double price) {
        this.toppings = pizza.getToppings();
        this.crust = pizza.getCrust();
        this.size = pizza.getSize();
        this.price = price;
    }
    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }
    public Curst getCrust() {
        return crust;
    }
    public void setCrust(Curst crust) {
        this.crust = crust;
    }
    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return(""+size.toString()+","+toppings.toString()+","+crust.toString()+","+price);
    }
}
