package PracticCW;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class StudentTest {
    private ArrayList<Student> students;

    @BeforeEach
    void generator() {
        Random random = new Random(42);
        students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String name = "Student" + i;
            double rating = random.nextDouble() * 4.0;
            int missedClasses = random.nextInt(21);
            students.add(new Student(name, rating, missedClasses));
        }
    }

    @Test
    void testComparable() {
        Collections.sort(students);

        int minMissedClasses = 100;
        for (Student student : students) {
            minMissedClasses = Math.min(minMissedClasses, student.getMissedClasses());
        }
        Assertions.assertEquals(minMissedClasses, students.get(0).getMissedClasses());


        boolean foundEqual = false;
        for (int i = 0; i < students.size() - 1; i++) {
            Student current = students.get(i);
            Student next = students.get(i + 1);

            Assertions.assertEquals(true, current.compareTo(next) <= 0);

            if (current.getMissedClasses() == next.getMissedClasses() && Double.compare(current.getRating(), next.getRating()) != 0) {
                foundEqual = true;
                Assertions.assertEquals(true, current.getRating() > next.getRating());
                break;
            }
        }
    }

    @Test
    void testUtilityComparator() {
        Comparator<Student> utilityComparator = (Student a, Student b) -> Double.compare(a.getRating(), b.getRating());
//
//        new Comparator<Student>() {
//            @Override
//            public int compare(Student a, Student b) {
//                return Double.compare(calculateScore(b), calculateScore(a));
//            }
//
//        };

        students.sort(utilityComparator);

        for (int i = 0; i < students.size() - 1; i++) {
            double currentScore = (students.get(i).getRating() * 0.7) - (students.get(i).getMissedClasses() * 0.1);
            double nextScore = (students.get(i + 1).getRating() * 0.7) - (students.get(i + 1).getMissedClasses() * 0.1);
            Assertions.assertEquals(true, currentScore >= nextScore);
        }
    }

    public double calculateScore(Student student) {
        return (student.getRating() * 0.7) - (student.getMissedClasses() * 0.1);
    }

    @Test
    void testIteratorLogic() {
        ArrayList<Student> badStudents = new ArrayList<>();
        int originalSize = students.size();
        int LowRating = 0;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRating() < 2.0) {
                LowRating++;
                if (student.getMissedClasses() <= 15) {
                    badStudents.add(student);
                }
                iterator.remove();
            }
        }

        for (Student student : students) {
            Assertions.assertTrue(student.getRating() >= 2.0);
        }

        Assertions.assertEquals(originalSize - LowRating, students.size());

        for (Student badStudent : badStudents) {
            Assertions.assertEquals(true, badStudent.getRating() < 2.0 && badStudent.getMissedClasses() <= 15);
        }
    }
}
