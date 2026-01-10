package lld;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> list;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    public synchronized V get(K key) {

        Node<K, V> node = map.get(key);

        if(node == null)
            return null;

        list.moveToFirst(node);
        return node.val;
    }

    public synchronized void put(K key, V value) {

        Node<K, V> node = map.get(key);
        if(node != null) {
            node.val = value;
            list.moveToFirst(node);
        } else {
            if(map.size() >= capacity) {
                Node<K,V> lastNode = list.removeLast();
                if(lastNode != null)    map.remove(lastNode.key);
            }

            Node<K,V> newNode = new Node<>(key, value);
            list.addFirst(newNode);
            map.put(key, newNode);
        }
    }

    public synchronized void remove(K key) {
        if(!map.containsKey(key))
            return;

        Node<K, V> node = map.get(key);
        list.remove(node);
        map.remove(node.key);
    }
}
