package CW3_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Part2_Records {
    public static void main(String[] args) {
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

        List<PlayerProfile> prof = profiles.stream().sorted(Comparator.comparing(PlayerProfile::getScore).reversed()).toList();

        try{
            FileOutputStream fos = new FileOutputStream("/Users/peace/IdeaProjects/Spiski/src/CW3_2/records.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            for(PlayerProfile p : prof) {
                dos.writeUTF(p.getNickname());
                dos.writeLong(p.getScore());
            }
        }catch(Exception e){
            System.out.println(e);
        }

        System.out.println("_____ТОП РЕКОРДОВ_____");
        int count = 0;
        try(DataInputStream dis = new DataInputStream(new FileInputStream("/Users/peace/IdeaProjects/Spiski/src/CW3_2/records.dat"))){
            while(true) {
                count++;
                try {
                    String nickname = dis.readUTF();
                    long read = dis.readLong();
                    System.out.println("#" + count + " " + read + " - " + nickname);
                } catch (EOFException e) {
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }


    }
}
