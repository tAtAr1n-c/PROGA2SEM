package Practic_CW_2_2;

import java.util.List;
import java.util.Optional;

public class Task5 {
    public static void main(String[] args){
        List<Student> students = List.of(
                new Student("Аня", 19, "Java", 4.5, List.of("Теннис", "Кино")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")),
                new Student("Борис", 19, "Java", 4.9, List.of("Кино", "Чтение")),
                new Student("Света", 21, "C++", 4.0, List.of("Музыка", "Игры")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")));

        Optional<Student> s1 = students.stream()
                .filter(student -> student.getRating() == 5)
                .findFirst();
        s1.ifPresentOrElse(System.out::println, ()->System.out.println("Студент не найден"));
    }
}
