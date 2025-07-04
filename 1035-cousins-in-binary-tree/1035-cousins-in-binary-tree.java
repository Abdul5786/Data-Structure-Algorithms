
class Solution {

    int xDepth=Integer.MIN_VALUE , yDepth=Integer.MIN_VALUE;
    TreeNode xParent = null, yParent = null;
    public boolean isCousins(TreeNode root, int x, int y) 
    {
         

         dfs(root,null,0,x,y);
         return xDepth==yDepth && xParent!=yParent;
    }
    
    void dfs(TreeNode node , TreeNode parent, int depth,int x,int y)
    {
        if(node==null) return;

        if(node.val==x)
        {
            xDepth = depth;
            xParent=parent;
        }

        if(node.val==y)
        {
            yDepth=depth;
           yParent=parent;
        }

        dfs(node.left,node,depth+1,x,y);
        dfs(node.right,node,depth+1,x,y);
    }

}