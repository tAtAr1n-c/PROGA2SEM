package Practic_CW_2_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Аня", 19, "Java", 4.5, List.of("Теннис", "Кино")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")),
                new Student("Борис", 19, "Java", 4.9, List.of("Кино", "Чтение")),
                new Student("Света", 21, "C++", 4.0, List.of("Музыка", "Игры")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")));
        students.stream().skip(0)
                .limit(3)
                .filter(student -> student.getAge() > 19)
                .map(Student::getName)
                .forEach(System.out::println);
        long cou = students.stream().skip(0)
                .filter(student -> student.getAge() > 19)
                .map(Student::getName)
                .count();
        System.out.println(cou);
    }
}
