package CW3_1;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) throws IOException {
        String pathinput = "/Users/peace/IdeaProjects/Spiski/src/CW3_1/input.txt";
        String pathoutput = "/Users/peace/IdeaProjects/Spiski/src/CW3_1/output5.txt";


        BufferedReader br = new BufferedReader(new FileReader(pathinput));
        BufferedWriter bw = new BufferedWriter(new FileWriter(pathoutput));

        String line;
        Set<String> set = new HashSet<String>();
        while ((line = br.readLine()) != null) {
            String[] cells = line.split("[^a-zA-Zа-яА-Я]+");
            for(int i = 0; i < cells.length; i++){
                if(palindrom(cells[i].toLowerCase())){
                    set.add(cells[i]);
                }
            }
        }
        br.close();

        for(String s : set){
            bw.write(s);
            bw.newLine();
        }
        bw.close();

    }
    public static boolean palindrom(String str){
        if(str.length() == 1){return false;}
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1))
                return false;
        }
        return true;
    }
}
