public class ConstructQuadTree {
    static class TreeNode {
        public boolean val;
        public boolean isLeaf;

        public TreeNode topLeft;
        public TreeNode topRight;
        public TreeNode bottomLeft;
        public TreeNode bottomRight;

        public TreeNode(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }

        public TreeNode(boolean val, boolean isLeaf, TreeNode topLeft, TreeNode topRight,
            TreeNode bottomLeft, TreeNode bottomRight) {

            this.val = val;
            this.isLeaf = isLeaf;

            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public static TreeNode construct(int grid[][]){
        return build(grid, 0, 0, grid.length);
    }

    private static TreeNode build(int grid[][], int row, int col, int size){
        if(isLeaf(grid, row, col, size)){
            return new TreeNode(grid[row][col] == 1, true);
        }

        int half = size / 2;

        TreeNode topLeft = build(grid, row, col, half);
        TreeNode topRight = build(grid, row, col + half, half);
        TreeNode bottomLeft = build(grid, row + half, col, half);
        TreeNode bottomRight = build(grid, row + half, col + half, half);

        return new TreeNode(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private static boolean isLeaf(int[][] grid, int row, int col, int size) {

        int val = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void print(TreeNode root) {

        System.out.print("[");
        dfs(root);
        System.out.println("]");
    }

    private static void dfs(TreeNode root) {

        if (root == null) return;

        int val = root.val ? 1 : 0;
        int isLeaf = root.isLeaf ? 1 : 0;

        System.out.print("[" + val + "," + isLeaf + "]");

        if (!root.isLeaf) {

            System.out.print(",");

            dfs(root.topLeft);

            System.out.print(",");

            dfs(root.topRight);

            System.out.print(",");

            dfs(root.bottomLeft);

            System.out.print(",");

            dfs(root.bottomRight);
        }
    }

    public static void main(String[] args) {

        int[][] grid = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0}
        };

        TreeNode root = construct(grid);
        print(root);
    }
}