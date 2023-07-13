import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Map;

public class BinTree {
    Node root = null;

    enum Color {red, black}

    ;

    public class Node {
        int value;
        Node left;
        Node right;
        Color color;

        public Node(int value) {
            this.value = value;
            this.color = Color.red;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + ", color=" + color + "}";
        }
    }

    public boolean add(int value) {
        if (root == null) {
            root = new Node(value);
            root.color = Color.black;
            return true;
        } else {
            Node newnode = addNode(root, value);
            root = rebalance(root);
            root.color = Color.black;
            return newnode != null;
        }
    }

    private Node addNode(Node node, int value) {
        if (node.value == value) {
            return null;
        }
        if (node.value > value) {
            if (node.left == null) {
                node.left = new Node(value);
                return node.left;
            } else {
                Node newNode = addNode(node.left, value);
                node.left = rebalance(node.left);
                return newNode;
            }
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                return node.right;
            } else {
                Node newNode = addNode(node.right, value);
                node.right = rebalance(node.right);
                return newNode;
            }
        }
    }

    private Node rebalance(Node node) {
        Node res = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (res.right != null && res.right.color == Color.red && (res.left == null || res.left.color == Color.black)) {
                needRebalance = true;
                res = rightSwap(res);
            }
            if (res.left != null && res.left.color == Color.red && res.left.left != null && res.left.left.color == Color.red) {
                needRebalance = true;
                res = leftSwap(res);
            }
            if (res.left != null && res.left.color == Color.red && res.right != null && res.right.color == Color.red) {
                needRebalance = true;
                colorSwap(res);
            }

        } while (needRebalance);

        return res;
    }

    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = right.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.red;
        return right;
    }

    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.red;
        return left;
    }

    private void colorSwap(Node node) {
        node.right.color = Color.black;
        node.left.color = Color.black;
        node.color = Color.red;
    }

    public boolean contain(int value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value == value) return true;
            if (currentNode.value > value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return false;
    }
}
