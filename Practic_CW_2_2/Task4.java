package Practic_CW_2_2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args){
        List<Student> students = List.of(
                new Student("Аня", 19, "Java", 4.5, List.of("Теннис", "Кино")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")),
                new Student("Борис", 19, "Java", 4.9, List.of("Кино", "Чтение")),
                new Student("Света", 21, "C++", 4.0, List.of("Музыка", "Игры")),
                new Student("Иван", 20, "Python", 3.8, List.of("Игры", "Код")));

        Set<String> s1 = students.stream()
                .flatMap(s -> s.getHobby().stream())
                .collect(Collectors.toSet());

        Map<String, List<Student>> s2 = students.stream()
                .collect(Collectors.groupingBy(Student::getLanguage));

        String s3 = "Отличники: " + students.stream()
                .filter(student -> student.getRating() > 4)
                .map(Student::getName)
                .collect(Collectors.joining(", "));
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
