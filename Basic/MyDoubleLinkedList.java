package Basic;

public class MyDoubleLinkedList<T> implements MyList<T>{
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;


    @Override
    public void add(T data) {
        DoubleNode<T> newNode = new DoubleNode<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        DoubleNode<T> newNode = new DoubleNode<>(item);

        if (size == 0) {
            head = tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoubleNode<T> current;
            if (index < size / 2) {
                current = head;
                for (int i = 0; i < index; i++) current = current.next;
            } else {
                current = tail;
                for (int i = size - 1; i > index; i--) current = current.prev;
            }
            DoubleNode<T> previous = current.prev;
            previous.next = newNode;
            newNode.prev = previous;
            newNode.next = current;
            current.prev = newNode;
        }

        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        DoubleNode<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current.data;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        DoubleNode<T> removed;
        if (index < size / 2) {
            removed = head;
            for (int i = 0; i < index; i++) {
                removed = removed.next;
            }
        } else {
            removed = tail;
            for (int i = size - 1; i > index; i--) {
                removed = removed.prev;
            }
        }
        DoubleNode<T> previous = removed.prev;
        DoubleNode<T> next = removed.next;
        if (previous == null) {
            head = next;
        } else {
            previous.next = next;
        }

        if (next == null) {
            tail = previous;
        } else {
            next.prev = previous;
        }
        size--;
        return removed.data;
    }

    @Override
    public boolean remove(T item) {
        if(contains(item)){
            remove(indexOf(item));
            return true;
        }else{
            return false;
        }
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
        tail = null;
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(T item) {
        DoubleNode<T> current = head;
        int index = 0;
        while (current != null && current.data.equals(item)){
            current = current.next;
            index++;
        }
        if(index == size){
            return -1;
        }
        return index;
    }
}
