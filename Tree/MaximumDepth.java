public class MaximumDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static TreeNode buildTree(int nodes[]){
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

    public static int maxDepth(TreeNode root){
        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, -1, -1, 3, -1, -1};
        BinaryTree.idx = -1;

        TreeNode root = BinaryTree.buildTree(nodes);
        int depth = maxDepth(root);

        System.out.println("Maximum Depth : " + depth);
    }
}