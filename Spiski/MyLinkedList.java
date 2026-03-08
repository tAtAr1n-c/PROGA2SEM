package Basic;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private int size;


    @Override
    public void add(T item) {
        if(isEmpty()){
            head = new Node<>(item);
        }else{
            Node<T> current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node<>(item);
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(isEmpty()){
            head = new Node<>(item);
        }else if(size == index){
            add(item);
        }else{
            Node<T> konec = new Node<>(item);
            Node<T> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            konec.next = current.next;
            current.next = konec;
        }
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    public T remove(int index) {
        Node<T> current = head;
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }else if(size == index){
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            current = null;
            size--;
        }else if(size == index){
            T data = current.data;
            head = head.next;
            return data;
        }
        current = head;
        for(int i = 0; i < index - 1; i++){
            current = current.next;
        }
        T k = current.next.data;
        current.next = current.next.next;
        size--;
        return k;

    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if(index == -1){
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean contains(T item) {
        boolean flag = false;
        Node<T> current = head;
        for(int i = 0; i < size; i++){
            if(current.data.equals(item)){
                return true;
            }else{
                current = current.next;
            }
        }
        return flag;
    }

    @Override
    public int indexOf(T item) {
        Node<T> current = head;
        int count = 0;
        while(current.data != item){
            current = current.next;
            count++;
        }
        return count;
    }
}
