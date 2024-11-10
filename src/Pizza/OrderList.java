package Pizza;

import java.util.ArrayList;

public class OrderList {
    private ArrayList<Order> orders;
    public OrderList() {
        orders = new ArrayList<Order>();
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public void removeOrder(Order order) {
        orders.remove(order);
    }
    public int getANumber() {
     return orders.size();
    }

}
