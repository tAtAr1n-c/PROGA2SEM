package PracticCW;

import Basic.MyArrayList;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Салават", 4.9, 1));
        students.add(new Student("Миша", 4.2, 6));
        students.add(new Student("Аскар", 5.1, 2));
        students.add(new Student("Саид", 5.0, 0));
        students.add(new Student("Камил", 4.6, 7));
        students.add(new Student("Мирсаит", 4.4, 4));
        students.add(new Student("Янар", 3.9, 5));
        Collections.sort(students);
        System.out.println(students);




        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2){
                return o1.getName().compareTo(o2.getName());
            }
        };
        students.sort(comparator);
        System.out.println(students);



        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if(student.getMissedClasses() > 5){
                iterator.remove();
            }
        }
        System.out.println(students);
    }
}