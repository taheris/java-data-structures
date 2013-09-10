package main.com.taheris.data_structures.linear;

import main.com.taheris.data_structures.lookup.Node;

public class QueueList<ValueType> implements QueueADT<ValueType> {
    private Node<ValueType> head;
    private Node<ValueType> tail;

    public QueueList() {
        clear();
    }

    @Override
    public void enqueue(ValueType value) {
        if (head == null) {
            head = new Node<>(value, null);
            tail = head;
        } else {
            tail.setNext(new Node<>(value, null));
            tail = tail.getNext();
        }
    }

    @Override
    public ValueType dequeue() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty.");
        }

        if (head.getNext() == null) {
            ValueType value = head.getValue();
            head = null;
            tail = null;
            return value;
        } else {
            ValueType value = head.getValue();
            head = head.getNext();
            return value;
        }
    }

    @Override
    public ValueType head() {
        if (head == null) {
            throw new IllegalStateException("Queue is empty.");
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
        tail = null;
    }
}
