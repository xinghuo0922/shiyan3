package mimic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    @Test
    public void testRemoveExistingElement() {
        LinkedList<String> list = new LinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        assertTrue(list.remove("banana"));
        assertFalse(list.contains("banana"));
        assertEquals(2, list.size());
    }
    @Test
    public void testRemoveNonExistingElement() {
        LinkedList<String> list = new LinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("orange");

        assertFalse(list.remove("grape"));
        assertEquals(3, list.size());
    }

    @Test
    public void testRemoveFromEmptyList() {
        LinkedList<String> list = new LinkedList<>();
        assertFalse(list.remove("apple"));
        assertEquals(0, list.size());
    }
    @Test
    public void testRemoveNullFromNull() {
        LinkedList<String> list = new LinkedList<>();
        list.add(null);
        assertTrue(list.remove(null));
        assertEquals(0, list.size());
    }
}



