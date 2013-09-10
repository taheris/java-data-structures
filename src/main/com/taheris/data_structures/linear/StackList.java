package main.com.taheris.data_structures.linear;

import main.com.taheris.data_structures.lookup.Node;

public class StackList<T> implements StackADT<T> {
    private Node<T> head;

    public StackList() {
        head = null;
    }

    @Override
    public void push(T value) {
        head = new Node<>(value, head);
    }

    @Override
    public T pop() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        T value = head.getValue();
        head = head.getNext();
        return value;
    }

    @Override
    public T top() {
        if (head == null) {
            throw new IllegalStateException("Stack is empty.");
        }
        return head.getValue();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
    }
}
