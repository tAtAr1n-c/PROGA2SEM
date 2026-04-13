package PracticCW2_1.PracticCW2_1_Sam;

import java.util.ArrayList;
import java.util.function.Function;

public class Task3 {
    public static void main(String[] args) {
        Function<Integer, Integer> russianTax = (price) -> price - price * 20 / 100;
        Function<Integer, Integer> usTax = (price) -> price - price * 10 / 100;

        ArrayList<Integer> priceus = new ArrayList<>();
        priceus.add(100);
        priceus.add(500);
        priceus.add(1000);
        for(Integer price : priceus){
            System.out.println(usTax.apply(price));
            System.out.println(russianTax.apply(price));

        }

        System.out.println(priceus.toString());
    }
}
