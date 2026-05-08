public class DeleteNodeBST {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode insert(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(val < root.val){
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private static TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    static void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] arr = {50,30,70,20,40,60,80};

        TreeNode root = null;

        for(int val : arr){
            root = insert(root, val);
        }

        System.out.print("Before : ");
        inorder(root);
        System.out.println();

        root = deleteNode(root, 50);

        System.out.print("After : ");
        inorder(root);
    }
}