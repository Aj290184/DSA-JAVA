public class BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static TreeNode buildTree(int nodes[]) {
            idx++;

            if(nodes[idx] == -1){
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    static class BalancedTree {
        public static boolean isBalanced(TreeNode root){
            return check(root) != -1;
        }

        private static int check(TreeNode root){
            if(root == null) return 0;

            int left = check(root.left);
            if(left == -1) return -1;

            int right = check(root.left);
            if(right == -1) return -1;

            if(Math.abs(left - right) > 1) return -1;

            return 1 + Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        int[] nodes = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};
        BinaryTree.idx = -1;

        TreeNode root = BinaryTree.buildTree(nodes);

        boolean isBalanced = BalancedTree.isBalanced(root);

        System.out.println("Is Balanced : " + isBalanced);
    }
}