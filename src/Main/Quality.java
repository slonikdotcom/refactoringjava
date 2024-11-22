package Main;

public class Quality {
    private int value;

    public Quality(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        if (value < 50) {
            value++;
        }
    }

    public void decrease() {
        if (value > 0) {
            value--;
        }
    }

    public void setToZero() {
        value = 0;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
