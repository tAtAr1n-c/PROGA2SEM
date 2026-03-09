package Basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyDoubleLinkedListTest {
    private MyList<String> list;

    @BeforeEach
    void setUp(){
        list = new MyLinkedList<>();
    }

    @Test
    void testAddandSize(){
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        Assertions.assertEquals(true, list.contains("Test3"));
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(false, list.isEmpty());
    }

    @Test
    void testget(){
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");
        Assertions.assertEquals("Test3", list.remove(2));
        Assertions.assertEquals(3, list.indexOf("Test5"));
        Assertions.assertEquals(true, list.remove("Test5"));
    }
}