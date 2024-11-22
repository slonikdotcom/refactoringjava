package Main;

public class Name {
    private final String value;

    public Name(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return false;
    }

    @Override
    public String toString() {
        return value;
    }
}
