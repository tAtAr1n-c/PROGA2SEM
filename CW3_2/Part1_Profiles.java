package CW3_2;

import java.io.*;
import java.util.ArrayList;

public class Part1_Profiles implements Serializable {
    public static void main(String[] args){
        ArrayList<PlayerProfile> profiles = new ArrayList<PlayerProfile>();
        PlayerProfile p1 = new PlayerProfile("5eleba",  91, 5, true);
        PlayerProfile p2 = new PlayerProfile("av1nR",  90, 5, true);
        PlayerProfile p3 = new PlayerProfile("Свободная Вобла",  89, 5, true);
        profiles.add(p1);
        profiles.add(p2);
        profiles.add(p3);





        try{
            FileOutputStream fos = new FileOutputStream("/Users/peace/IdeaProjects/Spiski/src/CW3_2/profiles.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(PlayerProfile p : profiles){
                oos.writeObject(p);
            }
        }catch(Exception e){
            System.out.println(e);
        }



        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/peace/IdeaProjects/Spiski/src/CW3_2/profiles.dat"))){
            while(true){
                try{
                    PlayerProfile restored = (PlayerProfile) ois.readObject();
                    System.out.println(restored.toString());
                }catch(EOFException e){
                    break;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
