package Practic;

import Basic.MyList;
import Basic.MyArrayList;

public class InfinityNews {
    public static void generateFeed(MyList<String> list, int amount){
        for(int i = 0; i < amount; i++){
            list.add("News - " + i);
        }
    }
}
