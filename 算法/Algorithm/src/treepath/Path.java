package treepath;

import java.util.ArrayList;
import java.util.List;

public class Path {

    public static List<String> findAllPath(Node root) {
        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        List<String> leftPaths = findAllPath(root.left);
        List<String> rightPaths = findAllPath(root.right);

        for (String path : leftPaths) {
            paths.add(root.value + "->" + path);
        }

        for (String path : rightPaths) {
            paths.add(root.value + "->" + path);
        }

        if (paths.isEmpty()) {
            paths.add("" + root.value);
        }

        return paths;
    }

    public static void main(String[] args) {

        Node root = new Node(5);            //                      5
        root.left = new Node(2);            //              2               3
        root.left.left = new Node(6);       //          6       7       8       4
        root.left.right = new Node(7);      //
        root.right = new Node(3);           //
        root.right.left = new Node(8);      //
        root.right.right = new Node(4);     //

        List<String> paths = findAllPath(root);
        for (String path : paths) {
            System.out.println(path);
        }
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}