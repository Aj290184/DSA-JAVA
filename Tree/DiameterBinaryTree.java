public class DiameterBinaryTree {
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

    static class Diameter {
        static int diameter = 0;

        public static int diameterOfBinaryTree(TreeNode root){
            diameter = 0;
            maxDepth(root);
            return diameter;
        }

        private static int maxDepth(TreeNode root){
            if(root == null) return 0;

            int left = maxDepth(root.left);
            int right = maxDepth(root.right);

            diameter = Math.max(diameter, left + right);

            return 1 + Math.max(left, right);
        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree.idx = -1;

        TreeNode root = BinaryTree.buildTree(nodes);
        int ans = Diameter.diameterOfBinaryTree(root);

        System.out.println("Diameter is : " + ans);
    }
}