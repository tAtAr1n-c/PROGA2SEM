package Basic;

public class MyHashSet<K>{
    private static final Object PRESENT = new Object();
    private MyHashMap<K, Object> map;

    public MyHashSet(){
        map = new MyHashMap<>();
    }

    public boolean add(K key){
        return map.put(key, PRESENT) == null;
    }

    public boolean remove(Object o){
        return map.remove((K) o) != null;
    }

    public boolean contains(Object o){
        return map.containsKey((K) o);
    }

    public int size(){
        return map.size();
    }

    public boolean isEmpty(){
        return map.isEmpty();
    }

    public void clear(){
        map.clear();
    }
}
