package test.com.taheris.data_structures.trees;

import static org.junit.Assert.assertEquals;

import main.com.taheris.data_structures.lookup.LookupADT;
import main.com.taheris.data_structures.trees.BinarySearchTree;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BinaryTreeTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private LookupADT<Integer> tree;

    @Before
    public void init() {
        tree = new BinarySearchTree<>();
    }

    @Test
    public void insert() {
        tree.insert("test", 123);
        assertEquals((Integer) 123, tree.retrieve("test"));
    }

    @Test
    public void update() {
        tree.insert("test", 123);
        tree.update("test", 234);
        assertEquals((Integer) 234, tree.retrieve("test"));
    }

    @Test
    public void remove() {
        exception.expect(IllegalArgumentException.class);
        tree.remove("test");
    }
}
