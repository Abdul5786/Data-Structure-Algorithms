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
    public List<String> binaryTreePaths(TreeNode root) 
    {
      List<String> res =  new ArrayList<>();
      findPaths(root,"",res);
      return res;
    }

    private void findPaths(TreeNode root,String path,List<String> res)
    {

        if(root == null) return;

        path+=root.val;

        if(root.left==null && root.right==null)
        {
            res.add(path);
            return;
        }
       
       findPaths(root.left,path+"->",res);
       findPaths(root.right,path+"->",res);
    }
}