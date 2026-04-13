package PracticCW2_1.PracticCW2_1_Sam;

@FunctionalInterface
public interface Validator<T> {
    boolean check(T item);
}
