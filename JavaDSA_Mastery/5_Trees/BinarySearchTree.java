class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) { this.data = data; }
}

public class BinarySearchTree {
    TreeNode root;
    public void insert(int data) {
        root = insertRec(root, data);
    }
    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);
        if (data < root.data) root.left = insertRec(root.left, data);
        else if (data > root.data) root.right = insertRec(root.right, data);
        return root;
    }
    public boolean search(int data) {
        return searchRec(root, data);
    }
    private boolean searchRec(TreeNode root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5); bst.insert(3); bst.insert(7);
        System.out.println(bst.search(3)); // true
        System.out.println(bst.search(9)); // false
    }
}
