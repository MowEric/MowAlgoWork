package homework;

import homework.Dictionary;

public class LinkedDictionaryF<K,V> implements Dictionary<K,V> {

    /**
     * Writing the Node Class
     */

    public class Node {
        K key;
        V value;
        homework.LinkedDictionaryF.Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**  Creating the Head Of The Linked Dictionary*/
    private homework.LinkedDictionaryF.Node head = null;

    /** Traversing the Linked Dictionary (LD) and searching for a given key */
    @Override
    public V get(K key) {
        /** Making sure the LD  is not Empty */
        if (head == null) return null;
        /** Initializing n, to begin the Traversal */
        homework.LinkedDictionaryF.Node n = this.head;
        /** Going through the LD until there are no more elements, assuring Termination*/
        while(n != null){
            /** What we do if we find the element */
            if (n.key == key){
                return (V) n.value;
            }
            /** If the key is not at the given value, move to the next node*/
            n = n.next;
        }
        /** After going through the LD return what you found or return that you did not find anything */
        return (V) n.value;
    }

    /** Checking whether the LD is empty */
    @Override
    public boolean isEmpty() {
        homework.LinkedDictionaryF.Node n = head;
        /** If there is no head, there is no chain of Nodes to be linked, therefore it is empty*/
        if (n == null) return true;
        /** The only alternative to empty is not Empty */
        return false;
    }

    /** Adding or 'putting' elements in the dictionary*/
    @Override
    public void put(K key, V value) {
        /** Initializing the traversal variable making the head n */
        homework.LinkedDictionaryF.Node n = head;
        /** If the LD is empty, make a head with the arguments of the function and return the head's value*/
        if (head == null) {
            if (value == null) return;
            else               head = new homework.LinkedDictionaryF.Node(key, value);
            return;
        }

//        /** Checking if value is null, making the LD empty if that is the case */
//        //if (value == null && n == head) return (V) null;

        /** Checking to make it possible to overwrite values for nodes that have the same keys
         *  Using the prev keyword to preserve connection to the rest of the elements */
        homework.LinkedDictionaryF.Node prev = null;
        if (key.equals(n.key) && value != null) { n.value = value; return; }
        if (key.equals(n.key) && value == null) { head = head.next; return; }
        prev = n;
        n = n.next;
        while (n != null && !n.key.equals(key)) {
            prev = n;
            n = n.next;
        }
        /** Making sure our final value is not null, and returning it*/
        if (n != null) {
            if (value == null) prev.next = n.next;
            else               n.value = value;
        }
        else {
            if (value == null);
            else               prev.next = new homework.LinkedDictionaryF.Node(key, value);
        }
    }
}