package Pizza;

public enum Curst {
    DeepDish,
    Brooklyn,
    Pan,
    Thin,
    Stuffed,
    Handtossed;

    @Override
    public String toString() {
        return name();
    }
}