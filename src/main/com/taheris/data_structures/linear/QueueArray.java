package main.com.taheris.data_structures.linear;

public class QueueArray<T> implements QueueADT<T> {
    private T[] queueArray;
    private int head;
    private int tail;
    private int size;

    public QueueArray() {
        this(100);
    }

    @SuppressWarnings("unchecked")
    public QueueArray(int size) {
        queueArray = (T[]) new Object[size];
        clear();
    }

    @Override
    public void enqueue(T value) {
        if (size >= queueArray.length) {
            throw new IllegalStateException("Queue is full.");
        }
        queueArray[tail] = value;
        tail = (tail + 1) % queueArray.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty.");
        }
        int oldHead = head;
        head = (head + 1) % queueArray.length;
        size--;
        return queueArray[oldHead];
    }

    @Override
    public T head() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty.");
        }
        return queueArray[head];
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
}
