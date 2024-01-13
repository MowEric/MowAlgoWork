package homework;

import inclass.BinaryTree;

import java.util.ArrayList;

public class GeneralTree<T> {

    class Node {
        T value;
        ArrayList<Node> children = new ArrayList<>();

        private Node(T value) {
            this.value = value;
        }

        public String toString() {
            String s = "(" + value;
            if (this.children.size() > 0) {
                s += " ";
            }
            int i = 0;
            for(i = 0; i < this.children.size(); i++) {
                if (i != this.children.size()-1) {
                    s += this.children.get(i).toString() + " ";
                }
                else {
                    s += this.children.get(i).toString();
                }

            }
            s += ")";
            return s;
        }
    }

    private Node root;

    public String toString() {
        if (root == null) {
            return "()";
        }
        return root.toString();
    }

    public void setRoot(T i) {
        root = new Node(i);
    }

    public void addChild(T parent, T child) {
        Node n = new Node(child);
        Node b = root;
        if (b.value == parent) {
            root.children.add(n);
        } else {
            addChild(b, parent, child);
        }
    }

    public void addChild(Node b, T parent, T child) {
        if (b.value == parent) {
            Node n = new Node(child);
            b.children.add(n);
            return;
        }
        for (int i = 0; i < b.children.size(); i++) {
            addChild(b.children.get(i), parent, child);
        }
    }

}
