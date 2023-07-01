class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> res=new ArrayList<>();
      if(root==null) return res;
      Queue<TreeNode> q=new LinkedList<>();
      q.add(root);
      int level = 1;
      while(!q.isEmpty()){
          List<Integer> list=new ArrayList<>();
          int size = q.size();
          for(int i=0;i<size;i++){
              TreeNode curr = q.poll();
            list.add(curr.val);
            if(curr.left!=null){
                q.add(curr.left);
            }
            if(curr.right!=null){
                q.add(curr.right);
            }
          }
        if(level%2==0){
            Collections.reverse(list);
        }
        res.add(list);
        level++;
      }
      return res;
    }
}
