public enum Size {
    //enum class
    DELUXE(16.99,18.99,20.99),
    BBQCHICKEN(14.99,16.99,19.99),
    MEATZZA(17.99,19.99,21.99),
    BILDYOUROWN(8.99,10.99,12.99);
    private final double small;
    private final double medium;
    private final double large;
    Size(double small, double medium, double large) {
        this.small = small;
        this.medium = medium;
        this.large = large;
    }
    public double getSmall() {
        return small;
    }
    public double getMedium() {
        return medium;
    }
    public double getLarge() {
        return large;
    }
}
