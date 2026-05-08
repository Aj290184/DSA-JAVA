class BinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode insert(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }

        return root;
    }

    public boolean search(TreeNode root, int target){
        if(root == null) return false;

        if(root.val == target)  return true;

        if(target < root.val){
            return search(root.left, target);
        }else{
            return search(root.right, target);
        }
    }

    public TreeNode delete(TreeNode root, int key){
        if(root == null) return null;

        if(key < root.val){
            root.left = delete(root.left, key);
        }else if(key > root.val){
            root.right = delete(root.right, key);
        }else{
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(root.right, key);
        }

        return root;
    }

    private  TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode buildBST(int arr[]){
        TreeNode root = null;

        for (int val : arr) {
            root = insert(root, val);
        }

        return root;
    }

    public TreeNode inorder(TreeNode root){
        if(root == null) return root;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        int[] arr = {4,2,7,1,3};

        TreeNode root = tree.buildBST(arr);

        System.out.print("Inorder: ");
        tree.inorder(root);

        System.out.println("\nSearch 7: " + tree.search(root, 7));
        System.out.println("Search 3: " + tree.search(root, 3));

        root = tree.delete(root, 2);

        System.out.print("After delete 2 : ");
        tree.inorder(root);
    }
}