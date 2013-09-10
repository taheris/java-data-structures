package main.com.taheris.data_structures.lookup;

public class Entry<T> {
    private Key key;
    private T value;

    public Entry(Key key, T value) {
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
