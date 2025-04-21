public class TreeExercises {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }
    Node root;
    // Count leaf nodes
    public int countLeaves(Node node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }
    // Height of tree
    public int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public static void main(String[] args) {
        TreeExercises tree = new TreeExercises();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("Leaf count: " + tree.countLeaves(tree.root));
        System.out.println("Tree height: " + tree.height(tree.root));
    }
}
