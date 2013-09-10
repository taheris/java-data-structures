package main.com.taheris.data_structures.lookup;

public interface KeyADT {
    public boolean equals(KeyADT key);
    public boolean lessThan(KeyADT key);
    public boolean greaterThan(KeyADT key);
    public String name();
}
