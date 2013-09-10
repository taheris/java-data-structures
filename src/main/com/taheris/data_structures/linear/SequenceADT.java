package main.com.taheris.data_structures.linear;

public interface SequenceADT<T> {
    public void insert(T value, int index);
    public void insertFirst(T value);
    public void insertLast(T value);
    public void delete(int index);
    public void deleteFirst();
    public void deleteLast();
    public T get(int index);
    public T getFirst();
    public T getLast();
    public boolean isEmpty();
    public void clear();
    public int size();
}
