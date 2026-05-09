package CW3_2;

import java.io.*;
import java.util.*;

public class Dopzad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> rus = new ArrayList<>();
        ArrayList<String> tat = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(
                "/Users/peace/IdeaProjects/Spiski/src/CW3_2/russian_tatar_dictionary.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" - ");
                rus.add(words[0].trim());
                tat.add(words[1].trim());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        Random rand = new Random();
        int index = rand.nextInt(rus.size());
        String rusSlov =  rus.get(index);
        System.out.println("Переведи слово с русского: " + rusSlov);
        String polz = scanner.nextLine();
        String tatSlov = tat.get(index);
        if(polz.equals(tatSlov)){
            System.out.println("Маладис");
        }else{
            System.out.println("Ну ты и кутак БАШ ваще-то вот так: " + tatSlov);

        }
    }
}
