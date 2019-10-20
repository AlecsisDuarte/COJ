package util;

public class TreeSort<T extends Comparable<T>> {
    class Node {
        T key;
        Node left, right;

        public Node(T item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    public TreeSort() {
        root = null;
    }

    public void insert(T item) {
        if (root == null) {
            root = new Node(item);
        } else {
            insertChild(item, root);
        }
    }

    private Node insertChild(T item, Node node) {
        if (node == null) {
            node = new Node(item);
        } else if (node.key.compareTo(item) > 0) {
            node.left = insertChild(item, node.left);
        } else {
            node.right = insertChild(item, node.right);
        }
        return node;
    }

    public void inorderPrint() {
        StringBuilder result = new StringBuilder();
        inorderPrint(root, result);
        System.out.println(result);
    }

    private void inorderPrint(Node node, StringBuilder line) {
        if (node != null) {
            inorderPrint(node.left, line);
            line.append(node.key);
            inorderPrint(node.right, line);
        }
    }
}