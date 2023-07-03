
class Solution {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        if(prev!=null &&root.val<prev.val){
            if(first==null)
            {
                first=prev;
                middle=root;
            }else{
                last=root;
            }
        }
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=null;
        middle=null;
        last=null;
        prev=new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(last!=null && first!=null){
            int t=first.val;
            first.val=last.val;
            last.val=t;    
        }
        else if(first!=null&& middle!=null){
            int t=first.val;
            first.val=middle.val;
            middle.val=t;
        }
        
    }
}
