package test.com.taheris.data_structures.linear;

import static org.junit.Assert.assertEquals;

import main.com.taheris.data_structures.linear.SequenceADT;
import main.com.taheris.data_structures.linear.SequenceArray;
import main.com.taheris.data_structures.linear.SequenceList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SequenceTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private SequenceADT<Integer> array;
    private SequenceADT<Integer> list;

    @Before
    public void init() {
        array = new SequenceArray<>();
        list = new SequenceList<>();
    }

    @Test
    public void insertDeleteArray() {
        array.insertFirst(10);
        assertEquals(1, array.size());

        array.delete(0);
        assertEquals(0, array.size());
    }

    @Test
    public void insertDeleteList() {
        list.insertFirst(5);
        assertEquals(1, list.size());

        list.delete(0);
        assertEquals(0, list.size());
    }

    @Test
    public void getArray() {
        array.insertFirst(5);
        array.insertFirst(6);
        assertEquals((Integer) 6, array.getFirst());
        assertEquals((Integer) 5, array.get(1));
    }

    @Test
    public void deleteEmptyArray() {
        exception.expect(IllegalStateException.class);
        array.deleteFirst();
    }

    @Test
    public void deleteEmptyList() {
        exception.expect(IllegalStateException.class);
        list.deleteFirst();
    }
}
