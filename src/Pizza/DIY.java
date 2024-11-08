package Pizza;

import java.util.ArrayList;

public class DIY {
    int countoppings;
    public double countTPrice() {
        return countoppings*1.69;
    }

    public  ArrayList<Topping> ChooseTopping(ArrayList<Topping> toppings) {
        if (toppings.size() >=7) {
            return null;
        }
        else{
            countoppings=toppings.size();
            return toppings;
        }
    }
}
