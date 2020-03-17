package ch.hslu.hashtable;

public class FancyInteger {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public FancyInteger(int value) {
        this.value = value;
    }

    private final int hashDiversity = 10;

    @Override
    public int hashCode() {
        return this.getValue() % hashDiversity;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FancyInteger)) {
            return false;
        }
        return this.getValue() == ((FancyInteger)obj).getValue();
    }
}
