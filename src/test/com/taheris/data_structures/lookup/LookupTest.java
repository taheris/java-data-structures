package test.com.taheris.data_structures.lookup;

import static org.junit.Assert.assertEquals;

import main.com.taheris.data_structures.lookup.LookupADT;
import main.com.taheris.data_structures.lookup.LookupBinary;
import main.com.taheris.data_structures.lookup.LookupLinear;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LookupTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private LookupADT<Integer> linear;
    private LookupADT<Integer> binary;

    @Before
    public void init() {
        linear = new LookupLinear<>();
        binary = new LookupBinary<>();
    }

    @Test
    public void insertLinear() {
        linear.insert("test", 123);
        assertEquals((Integer) 123, linear.retrieve("test"));
    }

    @Test
    public void insertBinary() {
        binary.insert("test", 5);
        assertEquals((Integer) 5, binary.retrieve("test"));
    }

    @Test
    public void updateLinear() {
        linear.insert("test", 123);
        linear.update("test", 234);
        assertEquals((Integer) 234, linear.retrieve("test"));
    }

    @Test
    public void removeLinear() {
        exception.expect(IllegalArgumentException.class);
        linear.remove("test");
    }
}

