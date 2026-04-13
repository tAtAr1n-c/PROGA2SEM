package PracticCW2_1.PracticCW2_1_Sam;

import java.util.ArrayList;
import java.util.List;
public class Task4{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(-5);
        list.add(10);
        list.add(-20);
        list.add(33);
        List<Integer> list2 = filterList(list, item -> item > 0);
        System.out.println(list2.toString());
    }

    public static <T> List<T> filterList(List<T> list, Validator<T> validator){
       List<T> list2 = new ArrayList<>();
       for(T t : list){
           if(validator.check(t)){
               list2.add(t);
           }
       }
       return list2;
    }


}
