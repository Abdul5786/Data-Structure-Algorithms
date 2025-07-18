
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        if(root==null || root==p || root==q) return root;

         // dive into left subtree and right subtree
         
         TreeNode left= lowestCommonAncestor(root.left,p,q);

         TreeNode right =lowestCommonAncestor(root.right,p,q);

         if(left!=null && right!=null) return root;

         return left!=null ? left:right;

         
    }
}