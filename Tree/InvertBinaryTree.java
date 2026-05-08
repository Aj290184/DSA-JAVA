public class InvertBinaryTree {

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static TreeNode buildTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            TreeNode root = new TreeNode(nodes[idx]);
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return root;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] nodes = {4,2,1,-1,-1,3,-1,-1,7,6,-1,-1,9,-1,-1};

        TreeNode root = BinaryTree.buildTree(nodes);

        System.out.print("Original (Inorder): ");
        inorder(root);

        invertTree(root);

        System.out.print("\nInverted (Inorder): ");
        inorder(root);
    }
}