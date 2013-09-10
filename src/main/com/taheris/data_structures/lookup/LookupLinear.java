package main.com.taheris.data_structures.lookup;

import main.com.taheris.data_structures.linear.SequenceADT;
import main.com.taheris.data_structures.linear.SequenceArray;

public class LookupLinear<T> implements LookupADT<T> {
    protected final SequenceADT<Entry<T>> sequence;

    public LookupLinear() {
        sequence = new SequenceArray<>();
    }

    @Override
    public void insert(String key, T value) {
        Entry<T> entry = new Entry<>(new Key(key), value);
        sequence.insertLast(entry);
    }

    @Override
    public void remove(String key) {
        Key find = new Key(key);

        int index = findKey(find);
        if (index < 0) {
            throw new IllegalArgumentException("Key not found.");
        }

        sequence.delete(index);
    }

    @Override
    public void update(String key, T value) {
        Key find = new Key(key);

        int index = findKey(find);
        if (index < 0) {
            throw new IllegalArgumentException("Key not found.");
        }

        sequence.delete(index);
        Entry<T> entry = new Entry<>(new Key(key), value);
        sequence.insert(entry, index);
    }

    @Override
    public T retrieve(String key) {
        Key find = new Key(key);

        int index = findKey(find);
        if (index < 0) {
            throw new IllegalArgumentException("Key not found.");
        }

        return sequence.get(index).getValue();
    }

    @Override
    public String stringify() {
        StringBuffer buffer = new StringBuffer();

        for (int index = 0; index < sequence.size(); index++) {
            Entry<T> entry = sequence.get(index);
            buffer.append(entry.getKey().name());
            buffer.append(":");
            buffer.append(entry.getValue().toString());
            if (index < sequence.size() - 1) {
                buffer.append(", ");
            }
        }

        return buffer.toString();
    }

    protected int findKey(Key key) {
        return linearSearch(key);
    }

    protected int linearSearch(Key key) {
        for (int index = 0; index < sequence.size(); index++) {
            Entry<T> entry = sequence.get(index);
            if (entry.getKey().equals(key)) {
                return index;
            }
        }

        return -1;
    }
}
