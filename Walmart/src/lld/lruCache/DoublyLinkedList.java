package lld.lruCache;

class DoublyLinkedList<K, V> {

    private final Node<K, V> head;
    private final Node<K, V> tail;

    public DoublyLinkedList() {
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node<K, V> node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void remove(Node<K,V> node) {

        if (node == head || node == tail) return;

        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void moveToFirst(Node<K, V> node) {
        remove(node);
        addFirst(node);
    }

    public Node<K,V> removeLast() {
        if(tail.prev == head) return null;
        Node<K, V> last = tail.prev;
        remove(last);

        // Optional but nice: detach pointers (helps avoid accidental misuse)
        last.prev = null;
        last.next = null;

        return last;
    }
}