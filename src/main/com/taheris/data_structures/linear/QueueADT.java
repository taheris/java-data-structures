package main.com.taheris.data_structures.linear;

public interface QueueADT<T> {
    public void enqueue(T value);
    public T dequeue();
    public T head();
    public boolean isEmpty();
    public void clear();
}
