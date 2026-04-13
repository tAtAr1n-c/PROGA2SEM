package Basic;

import java.util.Map;

public class MyHashMap<K,V> implements MyMap<K,V> {
    public Node<K, V>[] buckets;
    private int size;
    private static final int CAPACITY = 16;


    public static final class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public MyHashMap(){
        buckets =(Node<K, V>[]) new Node[CAPACITY];
        size = 0;
    }


    public int getBucketIndex(Object key){
        return Math.abs(key.hashCode() % buckets.length);
    }


    @Override
    public V put(K key, V value){
        if ((size + 1.0) / buckets.length > 0.75) {
            resize();
        }
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        while(current != null){
            if(current.key.equals(key)){
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            }
            current = current.next;
        }
        Node<K, V> node = new Node<>(key, value);
        node.next = buckets[index];
        buckets[index] = node;
        size++;
        return null;
    }


    @Override
    public V get(K key){
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        while(current != null){
            if(current.key.equals(key)){
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    @Override
    public boolean containsKey(K key){
        int index = getBucketIndex(key);
        Node<K, V> current = buckets[index];
        while(current != null){
            if(current.key.equals(key)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    @Override
    public boolean containsValue(V value){
        for(int i = 0; i < buckets.length; i++){
            Node<K, V> current = buckets[i];
            while(current != null){
                if(current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
    @Override
    public void clear(){
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = null;
        }
        size = 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }



    @Override
    public V remove(K key){
        int index = getBucketIndex(key);
        Node<K, V> prev = null;
        Node<K, V> current = buckets[index];
        while(current != null){
            if(current.key.equals(key)){
                if(prev == null){
                    buckets[index] = current.next;
                } else{
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    public void resize(){
        Node<K, V>[] oldBuckets = buckets;
        buckets = (Node<K, V>[]) new Node[oldBuckets.length * 2];
        size = 0;
        for (Node<K, V> head : oldBuckets) {
            Node<K, V> current = head;
            while (current != null) {
                put(current.key, current.value);
                current = current.next;
            }
        }
    }



}
