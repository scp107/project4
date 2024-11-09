package Pizza;

import java.util.ArrayList;

public class Order {
    private int number; //order number
    private ArrayList<Pizza> pizzas; //can use List<E> instead of ArrayList<E>
    Order(ArrayList<Pizza> pizzas, int number) {
        this.pizzas = pizzas;
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }
    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
