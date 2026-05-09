package CW3_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Task1 {
    public static void main(String[] args) throws IOException{
        String path = "/Users/peace/IdeaProjects/Spiski/src/CW3_1/students.csv";
        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;
        boolean fl = true;
        ArrayList<Student> students = new ArrayList<>();
        while((line = br.readLine()) != null){
            if(fl){
                fl = false;
                continue;
            }
            String[] cells = line.split(",");
            Student p = new Student(Integer.parseInt(cells[0]), cells[1], Integer.parseInt(cells[2]), cells[3]);
            System.out.println(p);
            students.add(p);
        }
        br.close();
        students.forEach(Student::toString);

        List<String> groups = students.stream().map(Student::getGroup).distinct().toList();
        groups.forEach(n->{
            System.out.println(n +" в этой группе столько студентов "+ students.stream().filter(k-> Objects.equals(k.getGroup(), n)).toList().size());
        });

    }
}
