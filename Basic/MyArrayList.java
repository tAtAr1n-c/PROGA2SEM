package Basic;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    protected T[] array;
    int capacity;
    private int now = 0;

    public MyArrayList(int capacity){
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public void add(T item) {
        proverka();
        array[now] = item;
        now++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > now) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + now);
        }
        proverka();
        for (int i = now; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        now++;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index >= now) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + now);
        }
        return array[index];
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= now) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + now);
        }
        T temp = array[index];
        T[] temp2 = (T[]) new Object[capacity];
        int j = 0;
        for (int i = 0; i < now; i++) {
            if (i != index) {
                temp2[j++] = array[i];
            }
        }
        array = temp2;
        now--;
        return temp;
    }

    @Override
    public boolean remove(T item) {
        return contains(item);
    }

    @Override
    public int size() {
        return now;
    }

    @Override
    public boolean isEmpty() {
        if(now == 0){
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[capacity];
        now = 0;
    }

    @Override
    public boolean contains(T item) {
        return !(indexOf(item) == -1);
    }

    @Override
    public int indexOf(T item) {
        for(int i = 0; i < now; i++){
            if(array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    private void proverka(){
        if(now == capacity){
            capacity = (int) (capacity * 1.5 + 1);
            T[] k = (T[]) new Object[capacity];
            for(int i = 0; i < now; i++){
                k[i] = array[i];
            }
            array = k;
        }
    }
}
