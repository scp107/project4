public enum Curst {
    DELUXE("Deep Dish","Brooklyn"),
    BBQCHICKEN("Pan","Thin"),
    MEATZZA("Stuffed","Hand-tossed"),
    BILDYOUROWN("Pan","Hand-tossed");
    final String CHCurst;
    final String NYCurst;
    Curst(String Chicago, String NewYork) {
        this.CHCurst = Chicago;
        this.NYCurst = NewYork;
    }
    public String getChicago(){
        return this.CHCurst;
    }
    public String getNewYork(){
        return this.NYCurst;
    }
}