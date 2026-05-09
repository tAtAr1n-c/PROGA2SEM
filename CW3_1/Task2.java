package CW3_1;

import java.io.*;
import java.util.*;

public class Task2 {
    public static void main(String[] args){
        try{
        String path = "/Users/peace/IdeaProjects/Spiski/src/CW3_1/numbers.txt";
        String path2 = "/Users/peace/IdeaProjects/Spiski/src/CW3_1/stats.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        BufferedWriter bw = new BufferedWriter(new FileWriter(path2));
        String line;
        LinkedList<Double> numbers = new LinkedList<>();
        int lineN = 0;
        while((line = br.readLine()) != null){
            double sum1 = 0;
            Arrays.stream(line.split(" ")).map(Double::parseDouble).toList().forEach(numbers::add);
            List<Double> list = new ArrayList<>();
            for (double d: Arrays.stream(line.split(" ")).map(Double::parseDouble).toList()) {
                sum1 += d;
            }
            bw.write("line " + lineN + " sum: " + sum1);
            bw.newLine();
            lineN++;
        }

        br.close();
        double sum = 0.0;
        Double min = null;
        Double max = null;
        for (double d : numbers) {
            sum += d;
            if (min == null || min > d) {
                min = d;
            }
            ;
            if (max == null || max < d) {
                max = d;
            }
        }
        bw.write("количество" + numbers.size());
        bw.newLine();
        bw.write("сумма" + sum);
        bw.newLine();
        bw.write("мин" + min);
        bw.newLine();
        bw.write("макс" + max);
        bw.newLine();
        bw.write("среднее" + sum / numbers.size());

        bw.close();
    }
        catch (IOException i) {
        System.out.println(i);
    }
    }
}
