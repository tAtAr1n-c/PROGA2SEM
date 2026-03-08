package Basic;

public interface MyList<T>{
    void add(T data);
    void add(int index, T item);
    T get(int index);
    T remove(int index);
    boolean remove(T item);
    int size();
    boolean isEmpty();
    void clear();
    boolean contains(T item);
    int indexOf(T item);
}