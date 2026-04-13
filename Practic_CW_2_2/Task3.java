package Practic_CW_2_2;

import java.util.List;
import java.util.function.Predicate;

public class Task3 {
    public static void main(String[] args){
        List<Student> students = List.of(
                new Student("Аня", 19, "Java", 4.5, List.of("Теннис", "Кино")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")),
                new Student("Борис", 19, "Java", 4.9, List.of("Кино", "Чтение")),
                new Student("Света", 21, "C++", 4.0, List.of("Музыка", "Игры")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")));

        boolean t1 = students.stream()
                .anyMatch(student -> student.getLanguage().equals("Java"));
        boolean t2 = students.stream()
                .allMatch(student -> student.getAge() >= 18);
        boolean t3 = students.stream()
                .noneMatch(student -> student.getRating() < 3);

        System.out.println(t1 && t2 && t3);
    }
}
