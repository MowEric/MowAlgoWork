package inclass;

public class LinkedSet<K> implements Set<K> {

    private class Node {
        K value;
        Node next;
        Node(K value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node first;

    public LinkedSet() {
        first = null;
    }

    @Override
    public void add(K key) {
        Node n = new Node(key);
        if (first == null) {
            first = n;
        } else {
            Node tail = first;
            while (tail.next != null && tail.value != key) {
                tail = tail.next;
            }
            if (tail.value != key) { //use assert instead
                tail.next = n;
            }
        }
    }

    @Override
    public boolean contains(K key) {
        Node current = first;
        while (current != null) {
            if (current.value.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void remove(K key) {
        Node current = first;
        if (first == null) {

        }
        else if (first.value == key) {
            first = first.next;
        } else {
            while (current.next != null) {
                if (current.next.value == key) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }

    }

}
