public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }

    public static void main(String[] args) {

        int[] arr = {6, 2, 8, 0, 4, 7, 9};

        TreeNode root = null;

        for (int val : arr) {
            root = insert(root, val);
        }

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        TreeNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("LCA : " + lca.val);
    }
}