import java.util.*;

public class LevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }

    static void printLevels(List<List<Integer>> levels) {
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }

    public static void main(String[] args) {

        /*
                3
               / \
              9  20
                 / \
                15  7
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrder(root);

        System.out.println("Level Order Traversal:");
        printLevels(result);
    }
}