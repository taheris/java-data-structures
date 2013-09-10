package main.com.taheris.data_structures.lookup;

public class Key implements KeyADT {
    private final String name;

    public Key() {
        this(null);
    }

    public Key(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(KeyADT key) {
        return key.name().equals(name);
    }

    @Override
    public boolean lessThan(KeyADT key) {
        return name.compareTo(key.name()) < 0;
    }

    @Override
    public boolean greaterThan(KeyADT key) {
        return name.compareTo(key.name()) > 0;
    }

    @Override
    public String name() {
        return name;
    }
}
