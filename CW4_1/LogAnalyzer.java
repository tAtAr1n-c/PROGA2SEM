package CW4_1;

import java.util.List;

public class LogAnalyzer implements Runnable {



    List<String> list;
    public int countError;
    public int countApi;


    public LogAnalyzer(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        countError = 0;
        countApi = 0;
        for(String l : list){
            if(l.contains("ERROR")){
                countError++;
            }
            if(l.contains("/api/users")){
                countApi++;
            }
        }

        System.out.println("Count Error: " + countError);
        System.out.println("Count Api: " + countApi);
    }


}
