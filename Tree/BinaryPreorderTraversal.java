import java.util.*;

public class BinaryPreorderTraversal {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static TreeNode buildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private static void preorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.data);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        TreeNode root = BinaryTree.buildTree(nodes);

        List<Integer> result = preorderTraversal(root);

        System.out.println("Preorder traversal : " + result);
    }
}