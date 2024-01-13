package homework;

public class LinkedDictionary<K, V> implements Dictionary<K, V> {
    //K (key) will be a integer value and V (value) will be a string input.

    private class Node {
        K key;
        V value;
        Node next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedDictionary.Node first = null;

    @Override
    public V get(K key) {
        if (first == null) return null;
        Node n = this.first;
        for (; n!= null; n=n.next) {
            if (n.key == key) {
                return n.value;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void put(K key, V value) {
        Node n = first;
        if (n == null) {
            if (value == null) return;
            else first = new Node(key, value);
            return;
        }

        Node tail = null;
        if(key.equals(n.key) && value != null) {
            n.value = value;
            return;
        }
        if(key.equals(n.key) && value == null) {
            first = first.next;
            return;
        }

        tail = n;
        n = n.next;

        while (n != null && !n.key.equals(key)) {
            tail = n;
            n = n.next;
        }
        if (n != null) {
            if (value == null) tail.next = n.next;
            else               n.value = value;
        }
        else {
            if (value == null) ;
            else tail.next = new Node(key, value);
        }
    }
}





