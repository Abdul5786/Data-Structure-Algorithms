/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min;
    int ans=-1;
    public int findSecondMinimumValue(TreeNode root) 
    {
        min=root.val;
        
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root)
    {

        if(root==null) return;

        if(root.val>min)
        {

            if(ans==-1 || root.val<ans)
            {
                ans=root.val;
            }
        }

        dfs(root.left);
        dfs(root.right);
    }
}