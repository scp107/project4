package Pizza;

import java.util.ArrayList;

public class Order {
    private int number; //order number
    private ArrayList<Pizza> pizzas; //can use List<E> instead of ArrayList<E>
    Order() {
        pizzas = new ArrayList<Pizza>(1);
        number = 0;
    }
    Order(int number, ArrayList<Pizza> pizzas) {
        this.number=number;
        this.pizzas=pizzas;
    }
    private void getANumber(){
        this.number=pizzas.hashCode();
    }
    public void add(Pizza pizza){
        pizzas.add(pizza);
    }
    public void pushToOrderList(OrderList orderList){
        getANumber();
        orderList.addOrder(new Order(this.number,this.pizzas));
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

    @Override
    public String toString(){
        String output = "";
        for(int i=0;i<pizzas.size();i++){
            output=output+pizzas.get(i).toString();
        }
        output=output+"\n"+this.number;
        return output;
    }
}
