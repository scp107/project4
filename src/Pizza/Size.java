package Pizza;

public enum Size {
    //enum class
    Small(16.99,14.99,17.99,8.99),
    Medium(18.99,16.99,19.99,10.99),
    Large(20.99,19.99,21.99,12.99);
    private final double Deluxe;
    private final double Chicken;
    private final double Meatzza;
    private final double BUO;
    Size(double Deluxe,double Chicken,double Meatzza,double Buo){
        this.Deluxe=Deluxe;
        this.Chicken=Chicken;
        this.Meatzza=Meatzza;
        this.BUO=Buo;
    }
    public double getDeluxe(){
        return Deluxe;
    }
    public double getChicken(){
        return Chicken;
    }
    public double getMeatzza(){
        return Meatzza;
    }
    public double getBuo(){
        return BUO;
    }
}
