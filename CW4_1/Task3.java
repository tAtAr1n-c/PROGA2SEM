package CW4_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите слова для поиска через пробел:");
        String input = scanner.nextLine();
        List<String> keywords = Arrays.stream(input.toLowerCase().split("\\s+"))
                .filter(s -> !s.isBlank())
                .toList();

        File folder = new File("/Users/peace/IdeaProjects/Spiski/src/CW4_1/docs");
        File[] txtFiles = folder.listFiles(
                (dir, name) -> name.endsWith(".txt")
        );

        int len = txtFiles.length;

        List<File> files1 = new ArrayList();
        List<File> files2 = new ArrayList();
        List<File> files3 = new ArrayList();

        int count = 0;
        for(File file : txtFiles){
            count++;
            if(count % 3 == 1){
                files1.add(file);
            }else if(count % 3 == 2){
                files2.add(file);
            }else{
                files3.add(file);
            }
        }

        SearchWorker s1 = new SearchWorker(files1, keywords);
        SearchWorker s2 = new SearchWorker(files2, keywords);
        SearchWorker s3 = new SearchWorker(files3, keywords);

        Thread thread1 = new Thread(s1);
        Thread thread2 = new Thread(s2);
        Thread thread3 = new Thread(s3);


        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка ожидания потоков: " + e.getMessage());
        }

        List<Map<String, List<Integer>>> newList = new ArrayList<>();

        newList.add(s1.results);
        newList.add(s2.results);
        newList.add(s3.results);

        Map<String, List<Integer>> finalResult = newList.stream()
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> new ArrayList<>(entry.getValue()),
                        (list1, list2) -> {
                            list1.addAll(list2);
                            return list1;
                        }
                ));

        try (
                FileWriter fw = new FileWriter("/Users/peace/IdeaProjects/Spiski/src/CW4_1/result3.txt");
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write("Результаты поиска:");
            bw.newLine();

            for (String fileName : finalResult.keySet()) {
                String text = fileName + " - " + finalResult.get(fileName);

                System.out.println(text);

                bw.write(text);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }


}
