package minleaf;

public class MinLeafNode {

    private static int minNode = Integer.MAX_VALUE;

    public static int findMinNode(Node root) {      //获取最小叶子节点的值

        if(root == null) {                          //到叶子节点终止递归
            return 0;
        }

        int left = findMinNode(root.left);
        int right = findMinNode(root.right);
        minNode = Math.min(minNode, left + right + root.value); //minNode始终为最小叶子节点的值
        return minNode;
    }

    public static void main(String[] args) {
                                                   //                  这是一颗二叉树
        Node root = new Node(5);            //                      5
        root.left = new Node(2);            //              2               3
        root.left.left = new Node(6);       //          6       7       8       4
        root.left.right = new Node(7);      //
        root.right = new Node(3);           //
        root.right.left = new Node(8);      //
        root.right.right = new Node(4);     //

        System.out.println(findMinNode(root));
    }
}

class Node {            //节点类
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }
}