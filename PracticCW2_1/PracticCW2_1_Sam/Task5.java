package PracticCW2_1.PracticCW2_1_Sam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task5 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("apple");
        words.add("orange");
        words.add("banana");
        words.add("apple");

        Map<String, Integer> frequency = new HashMap<>();
        words.forEach(word -> frequency.merge(word, 1, Integer::sum));
        System.out.println(frequency);
    }
}
