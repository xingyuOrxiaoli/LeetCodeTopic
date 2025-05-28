package utils;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public List<Node> neighbors;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
