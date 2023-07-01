class Solution{
        int res = 0;
    public int distributeCoins(TreeNode root) {
        sum(root);
        return res;
    }
    private int sum(TreeNode root) {
        if (root == null) return 0;
        int left = sum(root.left);
        int right = sum(root.right);
        res += Math.abs(left) + Math.abs(right);
        return left + right + root.val - 1;
    }
}
