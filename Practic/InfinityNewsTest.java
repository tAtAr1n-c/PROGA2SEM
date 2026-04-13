package Practic;

import org.junit.jupiter.api.Test;
import Basic.*;
public class InfinityNewsTest {

    @Test
    public void infinityNewsTest(){
        int amount = 100000;

        MyList<String> arrayList = new MyArrayList<>(amount);
        long t1 = System.currentTimeMillis();
        InfinityNews.generateFeed(arrayList, amount);
        long e1 = System.currentTimeMillis() - t1;

        MyList<String> linkedList = new MyDoubleLinkedList<>();
        long t2 = System.currentTimeMillis();
        InfinityNews.generateFeed(linkedList, amount);
        long e2 = System.currentTimeMillis() - t2;

        System.out.println(e1 + " ms"); // 4771 ms
        System.out.println(e2 + " ms"); // 11 ms
        /* ФА

         */

    }
}
