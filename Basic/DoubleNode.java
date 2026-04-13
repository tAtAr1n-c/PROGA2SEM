package Basic;

public class DoubleNode<T> {
    protected T data;
    protected DoubleNode<T> next;
    protected DoubleNode<T> prev;

    public DoubleNode(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData(){
        return data;
    }

}
