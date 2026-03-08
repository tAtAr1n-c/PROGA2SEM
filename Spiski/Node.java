package Basic;

public class Node<E> {
    protected E data;
    Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }
    public Node(E data){
        this.data = data;
        this.next = null;
    }
}
