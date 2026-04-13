package Practic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Basic.MyHashSet;

public class VisitorTest{
    @Test
    void visitorsTest() {
        MyHashSet<Visitor> visitors = new MyHashSet<>();
        Visitor vasiliy = new Visitor("Василий", "123");

        visitors.add(vasiliy);
        Assertions.assertTrue(visitors.contains(vasiliy));

        vasiliy.setPassId("999");

        Assertions.assertFalse(visitors.contains(vasiliy));
        /*
        Выводит false потому-что в HashSet он стоит на месте по старому HashCode
        мы перепресвоили passId и не нашли его он так как Хэш тоже изменился и мы ищем его уже в другом месте
        а там пусто =)
         */
    }
}