
class Solution {

    int res=0;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root)
    {
        if(root==null) return 0;

        int leftMax= dfs(root.left);
        int rightMax=dfs(root.right);

        res= Math.max(res, leftMax+rightMax);

        return 1+Math.max( leftMax,rightMax);
    }
}