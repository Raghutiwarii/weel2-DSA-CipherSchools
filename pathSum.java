class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return ans;
        hasPathSum(root,targetSum);
        return ans;
    }
    public void hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return;
        list.add(root.val);
        if(root.left==null && root.right==null) {
            if(targetSum == root.val){
                ans.add(new ArrayList<>(list));
            }
        }
        hasPathSum(root.left,targetSum-root.val);
        hasPathSum(root.right,targetSum-root.val);
        list.remove(list.size()-1);
    }
}
