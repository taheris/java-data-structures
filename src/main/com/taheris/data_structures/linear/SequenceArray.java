package main.com.taheris.data_structures.linear;

public class SequenceArray<T> implements SequenceADT<T> {
    private T[] sequence;
    private int head;
    private int tail;
    private int size;

    public SequenceArray() {
        this(100);
    }

    @SuppressWarnings("unchecked")
    public SequenceArray(int size) {
        sequence = (T[]) new Object[size];
        clear();
    }

    @Override
    public void insert(T value, int index) {
        if (size >= sequence.length) {
            throw new IllegalStateException("Sequence is full.");
        }

        head--;
        if (head < 0) {
            head += sequence.length;
        }
        sequence[head] = value;
        size++;
    }

    @Override
    public void insertFirst(T value) {
        insert(value, head);
    }

    @Override
    public void insertLast(T value) {
        if (size >= sequence.length) {
            throw new IllegalStateException("Sequence is full.");
        }

        sequence[tail] = value;
        tail = (tail + 1) % sequence.length;
        size++;
    }

    @Override
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of range.");
        }

        int start = (head + index) % sequence.length;
        for (int i = start; i < tail; i = (i + 1) % sequence.length) {
            sequence[i] = sequence[i + 1];
        }

        deleteLast();
    }

    @Override
    public void deleteFirst() {
        if (size == 0) {
            throw new IllegalStateException("Sequence is empty.");
        }

        delete(head);
    }

    @Override
    public void deleteLast() {
        if (size == 0) {
            throw new IllegalStateException("Sequence is empty.");
        }

        tail--;
        if (tail < 0) {
            tail += sequence.length;
        }
        size--;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of range.");
        }

        return sequence[(head + index) % sequence.length];
    }

    @Override
    public T getFirst() {
        return sequence[head];
    }

    @Override
    public T getLast() {
        return sequence[tail];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }
}
