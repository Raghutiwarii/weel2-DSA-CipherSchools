class Solution
{
   
    private static Node findNode(Node root,int target){
        if(root==null) return null;
        if(root.data==target) return root;
        Node left=findNode(root.left,target);
        Node right=findNode(root.right,target);
        if(left!=null) return left;
        if(right!=null) return right;
        return null;
    }
    
    private static void findParent(Map<Node,Node> mpp,Node root){
        if(root==null) return;
        if(root.left!=null) mpp.put(root.left,root);
        if(root.right!=null) mpp.put(root.right,root);
        
        findParent(mpp,root.left);
        findParent(mpp,root.right);
    }
    
    public static int minTime(Node root, int target) 
    {
        Map<Node,Node> map=new HashMap<>();
        if(root==null) return 0;
        Node targetNode=findNode(root,target);
        int ans=0;
        findParent(map,root);
        
        Queue<Node> q=new LinkedList<>();
        HashSet<Node> visited=new HashSet<>();
        
        q.offer(targetNode);
        
        while(!q.isEmpty()){
            int size=q.size();
            int flag=0;
            
            for(int i=0;i<size;i++){
                Node node=q.poll();
                visited.add(node);
                
                if(map.containsKey(node) && !visited.contains(map.get(node))){
                    q.offer(map.get(node));
                    flag=1;
                }
                if(node.left!=null && !visited.contains(node.left)){
                    q.offer(node.left);
                    flag=1;
                } 
             
                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                       flag=1;
                } 
                
            }
            if(flag==1) ans++;
        }
        return ans;
    }
}
