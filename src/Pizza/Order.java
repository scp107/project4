package Pizza;

import java.util.ArrayList;

public class Order {
    private int number; //order number
    private double prices;
    private ArrayList<Pizza> pizzas; //can use List<E> instead of ArrayList<E>
    Order() {
        pizzas = new ArrayList<Pizza>(1);
        number = 0;
        prices = 0;
    }
    Order(int number, ArrayList<Pizza> pizzas) {
        this.number=number;
        this.pizzas=pizzas;
    }
    public void addPrices(double price) {
        this.prices=price;
    }
    public void getANumber(){
        this.number=pizzas.hashCode();
    }
    public void add(Pizza pizza){
        pizzas.add(pizza);
    }
    public int getNumber() {
        return number;
    }
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public Pizza getPizza(int index){
        return pizzas.get(index);
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void deletePizza(int index){
        pizzas.remove(index);
    }
    public double getPrice(){
        return prices;
    }
    @Override
    public String toString(){
        String output = "";
        for(int i=0;i<pizzas.size();i++){
            output=output+pizzas.get(i).toString()+this.prices;
        }
        output=output+"\n"+this.number;
        return output;
    }
}
