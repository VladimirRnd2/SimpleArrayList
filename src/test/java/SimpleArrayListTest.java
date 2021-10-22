import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListTest {

    SimpleArrayList<String> stringList = new SimpleArrayList<>();
    SimpleArrayList<Integer> integerList = new SimpleArrayList<>();
    SimpleArrayList<Character> emptyList = new SimpleArrayList<>();

    @BeforeEach
    void setup() {
        stringList.add("One");
        stringList.add("Two");
        stringList.add("Four");
        stringList.add("Three");

        integerList.add(1);
        integerList.add(2);
        integerList.add(4);
        integerList.add(3);
   }

    @Test
    void add_to_StringList() {
        stringList.add("Six");
        assertTrue(stringList.get(4).equals("Six"));
    }

    @Test
    void add_to_IntegerList() {
        integerList.add(6);
        assertTrue(integerList.get(4) == 6);
    }

    @Test
    void add_null_to_emptyList() {
        emptyList.add(null);
        emptyList.add(null);
        emptyList.add(null);
        assertTrue(emptyList.size() == 3);
    }

    @Test
    void get_in_StringList() {
        assertEquals("One", stringList.get(0));
    }

    @Test
    void get_in_IntegerList() {
        assertEquals(1, integerList.get(0));
    }

    @Test
    void set() {
        stringList.set(2,"Five");
        assertTrue(stringList.get(2).equals("Five"));
    }

    @Test
    void remove() {
        integerList.remove(0);
        integerList.remove(0);
        assertTrue(integerList.size() == 2);
    }

    @Test
    void testRemove() {
        assertTrue(stringList.remove("One"));
    }

    @Test
    void size() {
        assertTrue(stringList.size() == 4);
        assertTrue(emptyList.size() == 0);
    }

    @Test
    void clear() {
        stringList.clear();
        assertTrue(stringList.size() == 0);
    }

    @Test
    void isEmpty() {
        assertFalse(stringList.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

}