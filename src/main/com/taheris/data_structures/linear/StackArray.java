package main.com.taheris.data_structures.linear;

public class StackArray<T> implements StackADT<T> {
    private T[] stackArray;
    private int stackSize;

    public StackArray() {
        this(100);
    }

    @SuppressWarnings("unchecked")
    public StackArray(int size) {
        stackArray = (T[]) new Object[size];
        stackSize = 0;
    }

    @Override
    public void push(T value) {
        if (stackSize >= stackArray.length) {
            throw new IllegalStateException("Stack is full.");
        }
        stackArray[stackSize++] = value;
    }

    @Override
    public T pop() {
        if (stackSize == 0) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stackArray[--stackSize];
    }

    @Override
    public T top() {
        if (stackSize == 0) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stackArray[stackSize - 1];
    }

    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    @Override
    public void clear() {
        stackSize = 0;
    }
}
