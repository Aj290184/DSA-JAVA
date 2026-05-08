public class GoodNodesBT {

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

            if (nodes[idx] == -1) return null;

            TreeNode root = new TreeNode(nodes[idx]);
            root.left = buildTree(nodes);
            root.right = buildTree(nodes);

            return root;
        }
    }
    
    public static int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return dfs(root, root.data);
    }

    public static int dfs(TreeNode node, int maxSoFar){
        if (node == null) return 0;

        int count = 0;

        if(node.data >= maxSoFar){
            count = 1;
        }

        maxSoFar = Math.max(maxSoFar, node.data);

        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
    public static void main(String[] args) {

        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        TreeNode root = BinaryTree.buildTree(nodes);

        int result = goodNodes(root);

        System.out.println("Good Nodes: " + result);
    }
}