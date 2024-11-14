package Pizza;

import java.util.ArrayList;

public class NYPizza implements PizzaFactory {
    private Size size;
    private ArrayList<Topping> toppings;
    private Curst curst;

    @Override
    public Pizza createDeluxe(Size size) {
        ArrayList<Topping> newToppings = new ArrayList<>();
        newToppings.add(Topping.SAUSAGE);
        newToppings.add(Topping.PEPPERONI);
        newToppings.add(Topping.GREENPEPPERS);
        newToppings.add(Topping.ONIONS);
        newToppings.add(Topping.MUSHROOMS);
        return new Pizza(newToppings, Curst.Brooklyn, size) {
            @Override
            public double price() {
                return size.getDeluxe();
            }
        };
    }

    @Override
    public Pizza createMeatzza(Size size) {
        ArrayList<Topping> newToppings = new ArrayList<>();
        newToppings.add(Topping.SAUSAGE);
        newToppings.add(Topping.PEPPERONI);
        newToppings.add(Topping.BEEF);
        newToppings.add(Topping.HAM);
        return new Pizza(newToppings, Curst.Handtossed,size) {
            @Override
            public double price() {
                return size.getMeatzza();
            }
        };
    }

    @Override
    public Pizza createBBQChicken(Size size) {
        ArrayList<Topping> newToppings = new ArrayList<>();
        newToppings.add(Topping.BBQCHICKEN);
        newToppings.add(Topping.GREENPEPPERS);
        newToppings.add(Topping.CHEDDAR);
        newToppings.add(Topping.PROVOLONE);
        return new Pizza(newToppings, Curst.Thin,size) {
            @Override
            public double price() {
                return size.getChicken();
            }
        };
    }

    @Override
    public Pizza createBuildYourOwn(Size size, ArrayList<Topping> toppings) {
        return new Pizza(toppings, Curst.Handtossed,size) {
            @Override
            public double price() {
                double price= size.getBuo()+(toppings.size()*1.69);
                return price;
            }
        };
    }



}
