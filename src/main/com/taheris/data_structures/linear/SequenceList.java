package main.com.taheris.data_structures.linear;

import main.com.taheris.data_structures.lookup.Node;

public class SequenceList<T> implements SequenceADT<T> {
    private Node<T> head;
    private Node<T> tail;

    public SequenceList() {
        clear();
    }

    @Override
    public void insert(T value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        } else if (index < 0 || head == null) {
            throw new IllegalArgumentException("Index out of range.");
        }

        Node<T> current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
            if (current == null) {
                throw new IllegalArgumentException("Index out of range.");
            }
        }

        current.setNext(new Node<>(value, current.getNext()));
        if (current == tail) {
            tail = tail.getNext();
        }
    }

    @Override
    public void insertFirst(T value) {
        if (head == null) {
            head = new Node<>(value, head);
            tail = head;
        } else {
            head = new Node<>(value, head);
        }
    }

    @Override
    public void insertLast(T value) {
        if (head == null) {
            head = new Node<>(value, null);
            tail = head;
        } else {
            tail.setNext(new Node<>(value, null));
            tail = tail.getNext();
        }
    }

    @Override
    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        } else if (index < 0 || head == null || head.getNext() == null) {
            throw new IllegalArgumentException("Index out of range.");
        }

        Node<T> current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
            if (current.getNext() == null) {
                throw new IllegalArgumentException("Index out of range.");
            }
        }

        if (current.getNext() == tail) {
            tail = current;
        }
        current.setNext(current.getNext().getNext());
    }

    @Override
    public void deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("Sequence is empty.");
        }

        if (head.getNext() == null) {
            clear();
        } else {
            head = head.getNext();
        }
    }

    @Override
    public void deleteLast() {
        if (head == null) {
            throw new IllegalStateException("Sequence is empty.");
        }

        if (head.getNext() == null) {
            clear();
        } else {
            Node<T> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            tail = current;
            current.setNext(null);
        }
    }

    @Override
    public T get(int index) {
        if (index == 0) {
            return getFirst();
        } else if (index < 0) {
            throw new IllegalArgumentException("Index out of range.");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                throw new IllegalArgumentException("Index out of range.");
            }
            current = current.getNext();
        }

        return current.getValue();
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new IllegalStateException("Sequence is empty.");
        }

        return head.getValue();
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new IllegalStateException("Sequence is empty.");
        }

        return tail.getValue();
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

    @Override
    public int size() {
        Node<T> current = head;

        int size = 0;
        while (current != null) {
            current = current.getNext();
            size++;
        }

        return size;
    }
}
