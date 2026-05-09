package CW4_1;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchWorker implements Runnable{
    List<File> files;
    List<String> keyWords;
    Map<String, List<Integer>> results = new HashMap<>();
    int total;

    public SearchWorker(List<File> files, List<String> keyWords) {
        this.files = files;
        this.keyWords = keyWords;
    }
    @Override
    public void run(){

            for (File file : files) {
                if (file.isFile()) {
                    try{
                        FileInputStream fis = new FileInputStream(file);
                        InputStreamReader isr = new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);
                        String line;
                        List<Integer> vhodiList = new ArrayList<>();
                        int count = 0;
                        while ((line = br.readLine()) != null) {
                            count++;
                            for(String word : keyWords){
                                if(line.toLowerCase().contains(word)){
                                    vhodiList.add(count);
                                    total++;
                                }
                            }
                        }
                        results.put(file.getName(), vhodiList);
                    }catch(Exception e){
                        System.out.println(e);
                    }

                }
            }


    }
}
