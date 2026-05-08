import java.util.*;

public class BTRightSideView {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx  = -1;

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

    public static List<Integer> rightSideView(TreeNode root){

        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();

                if(i == size - 1){
                    result.add(node.data);
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        TreeNode root = BinaryTree.buildTree(nodes);

        List<Integer> view = rightSideView(root);
        System.out.println(view);
    }
}