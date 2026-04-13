package PracticCW2_1.PracticCW2_1_Sam;

import java.util.HashMap;

public class InShop {
    public static void main(String[] args) {
        HashMap<String, Integer> thin = new HashMap<>();
        thin.put("Ноутбук", 100000);
        thin.put("Мышка", 5000);
        thin.put("Клава", 3000);
        thin.put("Чехол", 1000);
        final int discount = 15;
        thin.replaceAll((key, value) -> value - value * discount / 100);

        for(Integer i : thin.values()){
            System.out.println(i);
        }
    }
}
