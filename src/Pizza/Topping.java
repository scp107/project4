package Pizza;

public enum Topping {
    PEPPERONI(),
    SAUSAGE(),
    MUSHROOMS(),
    GREENPEPPERS(),
    ONIONS(),
    BBQCHICKEN(),
    PROVOLONE(),
    TOMATOES(),
    CHEDDAR(),
    HAM(),
    SPINACH(),
    BEEF();
    public String toString(){
        return name();
    }
}