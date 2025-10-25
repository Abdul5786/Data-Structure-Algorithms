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

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
       dfs(root);
       return res;
    }



    public int dfs(TreeNode root)
    {


        if(root==null) return 0;

       int leftNode = Math.max(dfs(root.left),0);
       int rightNode = Math.max(dfs(root.right),0);


       int pathSum = root.val + leftNode+rightNode;

       res = Math.max(pathSum,res);

       return root.val+Math.max(leftNode,rightNode);
        
    }

}