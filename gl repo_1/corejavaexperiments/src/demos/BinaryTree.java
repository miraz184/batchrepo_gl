package demos;

import java.util.Collection;

public class BinaryTree<T extends Comparable<T>> {
    private Node root;

    public void add(Collection<T> values) {
        for (T value : values) {
            add(value);
        }
    }


   public void add(T element) {
        if (root == null) {
            root = newNode(element);
            System.out.println(element + " added in root");
            return;
        }
        Node parent;
        Node current = root;
        while (true) {
            parent = current;
            int compare = element.compareTo(current.data);
            if (compare < 1) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode(element);
                    System.out.println(element + " added to left of " + parent.data);
                    return;
                }
                continue;
            }
            current = current.right;
            if (current == null) {
                parent.right = newNode(element);
                System.out.println(element + " added to right of " + parent.data);
                return;
            }
        }
    }

    public boolean findElement(T element) {
        Node current = root;
        while (current != null) {
            System.out.println("visited="+current.data);
            int compare = element.compareTo(current.data);
            if (compare == 0) {
                return true;
            }
            if (compare < 1) {
                current = current.left;
                continue;
            }
            current = current.right;
        }
        return false;

    }

     Node newNode(T data) {
        return new Node(data);
    }

    class Node {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
        }
    }

}
