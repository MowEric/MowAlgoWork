package inclass;

import com.sun.jdi.connect.Connector;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BinaryTree {

    class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }

        public String toString() {
            String s = "(" + value;
            if (left != null) s += left.toString();
            if (right != null) s += right.toString();
            return s + ")";
        }
    }

    private Node root;

    public BinaryTree() {
        root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
    }

    public String toString() {
        return root.toString();
    }

    public void traverse_inorder() {
        traverse_inorder(root);
    }

    private void traverse_inorder(Node n) {
        //In order: left, parent, right
        if (n != null) {
            traverse_inorder(n.left);
            StdOut.println(n.value);
            traverse_inorder(n.right);
        }
    }

    public void traverse_postorder() {
        traverse_postorder();
    }

    private void traverse_postorder(Node n) {
        //Postorder: left, right, parent
        if (n != null) {
            traverse_postorder(n.left);
            traverse_postorder(n.right);
            StdOut.println(n.value);
        }
    }

    private void bfs() {
        Queue<Node> q = new Queue<>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            Node n = q.dequeue();
            if (n != null) {
                StdOut.println(n.value);
                q.enqueue(n.left);
                q.enqueue(n.right);
            }
        }

    }


    //print
    //check null, go left, print left. then check right, go right, and print right.


    public static void main(String[] unused) {
        BinaryTree t = new BinaryTree();
        //StdOut.println(t.toString());
        //t.traverse_inorder();
        t.traverse_postorder();
    }

}