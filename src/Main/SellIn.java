package Main;

public class SellIn {
    private int value;

    public SellIn(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void decrease() {
        value--;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}