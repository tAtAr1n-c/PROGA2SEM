package PracticCW;

import java.util.function.Predicate;

public class Student implements Comparable<Student> {
    private String name;
    private double rating;
    private int missedClasses;

    public Student(String name, double rating, int missedClasses) {
        this.name = name;
        this.rating = rating;
        this.missedClasses = missedClasses;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getMissedClasses() {
        return missedClasses;
    }

    @Override
    public int compareTo(Student other) {
        int missedComparison = Integer.compare(this.missedClasses, other.missedClasses);
        if (missedComparison != 0) {
            return missedComparison;
        }
        int ratingComparison = Double.compare(other.rating, this.rating);
        if (ratingComparison != 0) {
            return ratingComparison;
        }
        return this.name.compareTo(other.name);

    }

    @Override
    public String toString() {
        return "\n\nStudent Name: " + name + "\nRating: " + rating + "\nMissed Classes: " + missedClasses;
    }


}
