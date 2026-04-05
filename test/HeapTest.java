package test;
import org.junit.Test;
import static org.junit.Assert.*;
import src.VectorHeap;

public class HeapTest{

    @Test
    public void testAddAndRemove(){
        VectorHeap<String> heap = new VectorHeap<>();

        heap.add("B");
        heap.add("C");
        heap.add("A");

        assertEquals("A", heap.remove().toString());
        assertEquals("B", heap.remove().toString());
        assertEquals("C", heap.remove().toString());
        if (!heap.isEmpty()){
            throw new AssertionError("Expected heap to be empty after removals.");
        }   
    }
    @Test
    private void assertEquals(String expected, String actual){
        if (!expected.equals(actual)){
            throw new AssertionError("Expected: " + expected + ", but got: " + actual);
        }
    }
}
