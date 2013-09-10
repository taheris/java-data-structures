package main.com.taheris.data_structures.lookup;

public interface LookupADT<T> {
    public void insert(String key, T value);
    public void remove(String key);
    public void update(String key, T value);
    public T retrieve(String key);
    public String stringify();
}
