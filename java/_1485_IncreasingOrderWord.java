/**
 * Problem: 1485 - Increasing Order Word
 * 
 * Description: You are given a word C of 1000 characters at most, and you must order its characters ascending. 
 *  In other words, you must find a permutation of its characters, which is lexicographically less than all.
 * Input: The only line of the input contain a word C.
 * Output: Print a single line with the ordered word C.
 * 
 * Sample:
 *  Input:
 *      adatda
 *  Output:
 *      aaaddt
 */
import java.util.Scanner;

public class _1485_IncreasingOrderWord {
    public static class TreeSort<T extends Comparable<T>> {
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

    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);
        final String line = scan.nextLine();
        scan.close();
        
        final TreeSort<Character> tree = new TreeSort<Character>();

        for (char letter : line.toCharArray()) {
            tree.insert(letter);
        }

        tree.inorderPrint();
    }
}

