package main.com.taheris.data_structures.linear;

public interface StackADT<T> {
    public void push(T value);
    public T pop();
    public T top();
    public boolean isEmpty();
    public void clear();
}
