package tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    private Node root;
    private int size;

    public void add(int val) {
        root = add(root, val);
    }

    public void loopAdd(int val) {
        if (null == root) {
            root = new Node(val);
            size++;
            return;
        }
        Node next = root;
        while (true) {
            if (val < next.val) {
                if (next.left == null) {
                    next.left = new Node(val);
                    size++;
                    return;
                }
                next = next.left;
            } else if (val > next.val) {
                if (next.right == null) {
                    next.right = new Node(val);
                    size++;
                    return;
                }
                next = next.right;
            }
        }
    }

    public Node add(Node root, int val) {
        if (root == null) {
            Node node = new Node(val);
            size++;
            return node;
        }
        if (val < root.val) {
            root.left = add(root.left, val);
        } else if (val > root.val) {
            root.right = add(root.right, val);
        }
        return root;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void preOrder() {
        preOrder(root);
    }


    private void preOrder(Node root) {
        if (null == root) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (null == root) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public boolean contains(int val) {
        return contains(root, val);
    }

    private boolean contains(Node root, int val) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return true;
        } else if (val < root.val) {
            return contains(root.left, val);
        } else {
            return contains(root.right, val);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node root, int depth, StringBuilder res) {
        if (root == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + root.val + " \n");
        generateBSTString(root.left, depth + 1, res);
        generateBSTString(root.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-");
        }
        res.append(" ");
        return res.toString();
    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<Node>();
        if (null != root) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.err.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node front = queue.remove();
            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }

    public int minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BTS is empty!");
        }
        return minimum(root).val;
    }

    private Node minimum(Node root) {
        if (root.left == null) {
            return root;
        }
        return minimum(root.left);
    }

    public int maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BTS is empty!");
        }
        return maxmum(root).val;
    }

    private Node maxmum(Node root) {
        if (root.right == null) {
            return root;
        }
        return maxmum(root.right);
    }

    public int removeMin() {
        int delMin = minimum();
        root = removeMin(root);
        return delMin;
    }

    private Node removeMin(Node root) {
        if (root.left == null) {
            Node right = root.right;
            root.right = null;
            size--;
            return right;
        }
        root.left = removeMin(root.left);
        return root;
    }

    public int removeMax() {
        int delMax = maximum();
        root = removeMax(root);
        return delMax;
    }

    private Node removeMax(Node root) {
        if (root.right == null) {
            Node left = root.left;
            root.left = null;
            size--;
            return left;
        }
        root.right = removeMax(root.right);
        return root;
    }

    public void remove(int val) {
        root = remove(root, val);
    }

    private Node remove(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = remove(root.left, val);
        } else if (val > root.val) {
            root.right = remove(root.right, val);
        } else {
            if (root.left == null) {
                Node right = root.right;
                root.right = null;
                size--;
                return right;
            }
            if (root.right == null) {
                Node left = root.left;
                root.left = null;
                size--;
                return left;
            }
            Node miniRight = minimum(root.right);
            miniRight.right = removeMin(root.right);
            miniRight.left = root.left;
            root.left = null;
            root.right = null;
            return miniRight;
        }
       return root;
    }

    static class Node {

        private int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 6, 8, 4, 2};
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        bst.remove(3);
        bst.levelOrder();
    }
}
