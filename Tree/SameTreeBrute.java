import java.util.*;
public class SameTreeBrute {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BinaryTree {
        static int idx;

        public static TreeNode buildTree(int[] nodes) {
            if (idx >= nodes.length || nodes[idx] == -1) {
                idx++;
                return null;
            }

            TreeNode root = new TreeNode(nodes[idx++]);
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);
            return root;
        }
    }

    static class Solution {
        public static boolean isSameTree(TreeNode p, TreeNode q) {
            List<String> t1 = new ArrayList<>();
            List<String> t2 = new ArrayList<>();

            serialize(p, t1);
            serialize(q, t2);

            return t1.equals(t2);
        }

        private static void serialize(TreeNode root, List<String> list) {
            if (root == null) {
                list.add("null");
                return;
            }

            list.add(String.valueOf(root.val));
            serialize(root.left, list);
            serialize(root.right, list);
        }
    }

    public static void main(String[] args) {
        int[] nodes1 = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};
        int[] nodes2 = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};

        BinaryTree.idx = 0;
        TreeNode root1 = BinaryTree.buildTree(nodes1);

        BinaryTree.idx = 0;
        TreeNode root2 = BinaryTree.buildTree(nodes2);

        boolean isSame = Solution.isSameTree(root1, root2);
        System.out.println("Is Same Tree: " + isSame);
    }
}