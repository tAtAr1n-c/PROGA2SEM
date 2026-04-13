package Practic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CloneAtackTest {

    @Test
    void cloneTest(){
        String[] clones = CloneAtack.generator();

        long start1 = System.currentTimeMillis();
        String duplicate1 = CloneAtack.findinArr(clones);
        long method1 = System.currentTimeMillis() - start1;

        long start2= System.currentTimeMillis();
        String duplicate2 = CloneAtack.findinHash(clones);
        long method2 = System.currentTimeMillis() - start2;


        System.out.println(method1 + " ms");
        System.out.println(method2 + " ms");
    }


    /*
    HASH - 11
    ARRAY - 4800
    в Array мы пробегаемся каждый раз по массиву один элемент сравниваем со всеми из-за этого скорость работы
    становитсяя О(n^2)
    в Hash легче мы вначале считаем хэш и проверяем уже не со всеми элементами а только с теми которые вместе с ним образуют коллизию
    То есть в определенной ячейке. Точно не знаю сколько думаю или O(n log n) or O(n) <- скорей это :)
     */
}
