package CW4_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args){

        ArrayList<String> osnMass = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("/Users/peace/IdeaProjects/Spiski/src/CW4_1/access.log");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                osnMass.add(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
        List<String> t1 = new ArrayList<>();
        List<String> t2 = new ArrayList<>();
        List<String> t3 = new ArrayList<>();
        List<String> t4 = new ArrayList<>();
        int size = osnMass.size();
        int count = size / 4;
        int i = 0;
        while (i < osnMass.size()) {
            if (i < count) {
                t1.add(osnMass.get(i));
            } else if (i < count * 2) {
                t2.add(osnMass.get(i));
            } else if (i < count * 3) {
                t3.add(osnMass.get(i));
            } else {
                t4.add(osnMass.get(i));
            }

            i++;
        }

        LogAnalyzer analyzer1 = new LogAnalyzer(t1);
        LogAnalyzer analyzer2 = new LogAnalyzer(t2);
        LogAnalyzer analyzer3 = new LogAnalyzer(t3);
        LogAnalyzer analyzer4 = new LogAnalyzer(t4);

        Thread thread1 = new Thread(analyzer1);
        Thread thread2 = new Thread(analyzer2);
        Thread thread3 = new Thread(analyzer3);
        Thread thread4 = new Thread(analyzer4);



        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            System.out.println();
        }

        int allErrors = analyzer1.countError
                + analyzer2.countError
                + analyzer3.countError
                + analyzer4.countError;

        int allApi = analyzer1.countApi
                + analyzer2.countApi
                + analyzer3.countApi
                + analyzer4.countApi;

        try{
            FileWriter fw = new FileWriter("/Users/peace/IdeaProjects/Spiski/src/CW4_1/result1.txt");
            fw.write("Общее количество ошибок: " + allErrors + "\n");
            fw.write("Общее количество обращений к api: " + allApi);
            fw.close();
        }catch(IOException e){
            System.out.println("SUSHI");
        }
    }
}