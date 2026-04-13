package PracticCW2_1.PracticCW2_1_Sam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Task6 {
    public static void main(String[] args){
        String[] w = {"Admin", "Moderator_1", "guest", "super_admin", "bot_99"};
        for(int i = 0; i < w.length; i++){
            w[i] = w[i].toLowerCase();
        }

        ArrayList<String> users = new ArrayList<>(List.of(w));

        Predicate<String> isLongEnough = name -> name.length() > 5;
        Predicate<String> containsAdmin = name -> name.contains("admin");
        Predicate<String> isNotBot = name -> name.contains("bot");
        Predicate<String> complexRule = isLongEnough.and(containsAdmin).and(isNotBot.negate());
        users.removeIf(complexRule.negate());
        System.out.println(users.toString());

    }

}
