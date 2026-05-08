public class SubtreeAnotherTree {

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

    static class Subtree {
        public static boolean isSubtree(TreeNode root, TreeNode subRoot){
            if (root == null) return subRoot == null;
            
            return isSubtree(root, subRoot) ||
            isSame(root.left, subRoot) ||
            isSame(root.right, subRoot);
        }

        private static boolean isSame(TreeNode a, TreeNode b){
            if(a == null && b == null) return a == b;

            return a.val == b.val && isSame(a.left, b.left) &&
            isSame(a.right, b.right);
        }
    }

    public static void main(String[] args) {

        int[] rootArr = {3,4,1,-1,-1,2,-1,-1,5,-1,-1};
        int[] subArr  = {4,1,-1,-1,2,-1,-1};

        BinaryTree.idx = -1;
        TreeNode root = BinaryTree.buildTree(rootArr);

        BinaryTree.idx = -1;
        TreeNode subRoot = BinaryTree.buildTree(subArr);

        boolean ans = Subtree.isSubtree(root, subRoot);

        System.out.println("Is Subtree: " + ans);
    }
}