package CW3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

public class Part3_Card {
    public static void main(String[] args){
        ArrayList<PlayerProfile> profiles = new ArrayList<PlayerProfile>();
        PlayerProfile p1 = new PlayerProfile("5eleba",  91, 130000, true);
        PlayerProfile p2 = new PlayerProfile("av1nR",  90, 140000, true);
        PlayerProfile p3 = new PlayerProfile("Свободная Вобла",  89, 120000, true);
        PlayerProfile p4 = new PlayerProfile("Настя пон",  89, 150000, true);
        PlayerProfile p5 = new PlayerProfile("Каки Коняки",  89, 160000, true);

        profiles.add(p1);
        profiles.add(p2);
        profiles.add(p3);
        profiles.add(p4);
        profiles.add(p5);


        String card = "";
        try(StringWriter sw = new StringWriter()){
            for(PlayerProfile p : profiles){
                sw.write("Карточка игрока\n");
                sw.write("Ник: " + p.getNickname()+ "\n");
                sw.write("Уровень: " + p.getLevel()+ "\n");
                sw.write("Счёт: " + p.getLevel() + "\n");
                sw.write("Статус: "+ p.isOnline()+"\n");
            }
            card = sw.toString();
        }catch(IOException e){
            System.out.println(e);
        }
        
        System.out.println(card);

        try{
            StringReader sr = new StringReader(card);
            BufferedReader br = new BufferedReader(sr);
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                count++;
                System.out.println(count + ": " + line);
                if(count == 5){
                    count = 0;
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
