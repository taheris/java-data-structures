package test.com.taheris.data_structures.linear;

import static org.junit.Assert.assertEquals;

import main.com.taheris.data_structures.linear.StackADT;
import main.com.taheris.data_structures.linear.StackArray;
import main.com.taheris.data_structures.linear.StackList;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private StackADT<Integer> array;
    private StackADT<Integer> list;

    @Before
    public void init() {
        array = new StackArray<>();
        list = new StackList<>();
    }

    @Test
    public void pushPopArray() {
        array.push(5);
        array.push(6);
        assertEquals((Integer) 6, array.pop());
    }

    @Test
    public void pushPopList() {
        list.push(5);
        list.push(6);
        assertEquals((Integer) 6, list.pop());
    }

    @Test
    public void popEmptyArray() {
        exception.expect(IllegalStateException.class);
        array.pop();
    }

    @Test
    public void popEmptyList() {
        exception.expect(IllegalStateException.class);
        list.pop();
    }
}

