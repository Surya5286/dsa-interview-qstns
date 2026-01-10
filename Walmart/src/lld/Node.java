package lld;

class Node<K, V> {
    K key;
    V val;
    Node<K, V> next, prev;

    public Node(K key, V val) {
        this.key = key;
        this.val = val;
    }
}