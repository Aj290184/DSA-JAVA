public class SameTreeOptimal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static TreeNode buildTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            TreeNode root = new TreeNode(nodes[idx++]);
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return root;
        }
    }

    static class SameTree {
        public static boolean isSameTree(TreeNode p, TreeNode q){
            if(p.left == null && q.left == null) return true;

            if (p == null || q == null) return false;

            if(p.val != q.val) return false;

            return isSameTree(p.left, q.left) &&
            isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {

        int[] nodes1 = {1, 2, -1, -1, 3, -1, -1};
        int[] nodes2 = {1, 2, -1, -1, 3, -1, -1};

        BinaryTree.idx = -1;
        TreeNode root1 = BinaryTree.buildTree(nodes1);

        BinaryTree.idx = -1;
        TreeNode root2 = BinaryTree.buildTree(nodes2);

        boolean result = SameTree.isSameTree(root1, root2);

        System.out.println("Is Same Tree : " + result);
    }
}