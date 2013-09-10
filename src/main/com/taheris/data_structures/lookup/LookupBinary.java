package main.com.taheris.data_structures.lookup;


public class LookupBinary<T> extends LookupLinear<T> {
    @Override
    public void insert(String key, T value) {
        Entry<T> entry = new Entry<>(new Key(key), value);

        int index = 0;
        while (index < sequence.size()
                && entry.getKey().greaterThan(sequence.get(index).getKey())) {
            index++;
        }

        sequence.insert(entry, index);
    }

    @Override
    protected int findKey(Key key) {
        return binarySearch(key, 0, sequence.size() - 1);
    }

    protected int binarySearch(Key key, int bottom, int top) {
        if (bottom > top) {
            return -1;
        }

        int middle = (bottom + top) / 2;
        Key middleKey = sequence.get(middle).getKey();

        if (key.equals(middleKey)) {
            return middle;
        } else if (key.greaterThan(middleKey)) {
            return binarySearch(key, middle + 1, top);
        } else {
            return binarySearch(key, bottom, middle - 1);
        }
    }
}
