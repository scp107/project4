package Pizza;

import java.util.ArrayList;

public abstract class Pizza {
    private ArrayList<Topping> toppings;
    private Curst crust;
    private Size size;
    public abstract double price();
    public Pizza(){
        this.toppings = new ArrayList<>();
        this.crust=null;
        this.size=null;
    }
    public Pizza(ArrayList<Topping> toppings, Curst crust, Size size) {
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }
    public ArrayList<Topping> getToppings() {return toppings;}
    public void setToppings(ArrayList<Topping> toppings) {this.toppings = toppings;}
    public Curst getCrust() {return crust;}
    public void setCrust(Curst crust) {this.crust = crust;}
    public Size getSize() {return size;}
    public void setSize(Size size) {this.size = size;}
    public String toString(){
        return(""+size.toString()+","+toppings.toString()+","+crust.toString());
    }
}
