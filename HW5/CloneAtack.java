package Practic;


import Basic.MyArrayList;
import Basic.MyHashSet;
import java.util.ArrayList;

public class CloneAtack {

    public static String[] generator(){
        String[] result = new String[100000];
        for(int i = 0; i < result.length - 1; i++){
            result[i] = "Gen-" + i;
        }
        result[result.length - 1] = result[88888];
        return result;
    }



    public static String findinArr(String[] clones){
        MyArrayList<String> result = new MyArrayList<>(clones.length);
        for(int i = 0; i < clones.length; i++){
            if(result.contains(clones[i])){
                return clones[i];
            }
            result.add(clones[i]);
        }
        return null;
    }

    public static String findinHash(String[] clones){
        MyHashSet<String> result = new MyHashSet<>();
        for(int i = 0; i < clones.length; i++){
            if(result.contains(clones[i])){
                return clones[i];
            }
            result.add(clones[i]);
        }
        return null;
    }
}