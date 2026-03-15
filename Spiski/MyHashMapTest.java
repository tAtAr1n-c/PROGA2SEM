package Basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {
    private MyHashMap<String, String> list;
    private MyHashSet<String> set;

    @BeforeEach
    void setUp(){
        list = new MyHashMap<>();
        set = new MyHashSet<>();
    }

    @Test
    void map(){
        list.put("key1", "value1");
        list.put("key2", "value2");
        list.put("key3", "value3");
        list.put("key4", "value4");
        Assertions.assertEquals("value1", list.get("key1"));
        Assertions.assertEquals(true, list.containsKey("key2"));
        Assertions.assertEquals("value4", list.get("key4"));
        list.clear();
        Assertions.assertEquals(false, list.containsValue("value3"));
        Assertions.assertEquals(0, list.size());
        Assertions.assertEquals(false, list.containsKey("key4"));
        list.resize();
        Assertions.assertEquals(32, list.buckets.length);
    }

    @Test
    void set(){
        set.add("key1");
        set.add("key2");
        set.add("key3");
        set.add("key4");
        set.add("key5");
        Assertions.assertEquals(true, set.contains("key2"));
        Assertions.assertEquals(true, set.remove("key1"));
        Assertions.assertEquals(false, set.contains("key1"));
        set.clear();

        Assertions.assertEquals(0, set.size());

    }
}
