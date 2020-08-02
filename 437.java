class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
    public class Soulation {
        int ans = 0;

        public int pathSum(TreeNode root, int sum) {
            if (root == null) return ans;
            dfs(root, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
            return ans;
        }

        public int dfs(TreeNode root, int sum) {
            if (root == null) return 0;
            sum -= root.val;
            if (sum == 0) {
                ans++;
            }
            dfs(root.left, sum);
            dfs(root.right, sum);
            return ans;
        }
    }
