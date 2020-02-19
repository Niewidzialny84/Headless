package niewidzialny84.github;

public class Pair {
    private boolean key;
    private double value;

    public Pair(boolean key, double value) {
        this.key = key;
        this.value = value;
    }

    public boolean getKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
