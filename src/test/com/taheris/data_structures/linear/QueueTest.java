package test.com.taheris.data_structures.linear;

import static org.junit.Assert.assertEquals;

import main.com.taheris.data_structures.linear.QueueADT;
import main.com.taheris.data_structures.linear.QueueArray;
import main.com.taheris.data_structures.linear.QueueList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class QueueTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private QueueADT<Integer> array;
    private QueueADT<Integer> list;

    @Before
    public void init() {
        array = new QueueArray<>();
        list = new QueueList<>();
    }

    @Test
    public void enqueueDequeueArray() {
        array.enqueue(10);
        array.enqueue(20);
        assertEquals((Integer) 10, array.dequeue());
    }

    @Test
    public void enqueueDequeueList() {
        list.enqueue(3);
        list.enqueue(4);
        assertEquals((Integer) 3, list.dequeue());
    }

    @Test
    public void headEmptyArray() {
        exception.expect(IllegalStateException.class);
        array.head();
    }

    @Test
    public void headEmptyList() {
        exception.expect(IllegalStateException.class);
        list.head();
    }
}
