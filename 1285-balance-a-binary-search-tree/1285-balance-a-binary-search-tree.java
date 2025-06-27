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

   List<Integer> res= new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) 
    {
        inorder(root);
        return build(0,res.size()-1);
    }

    void inorder(TreeNode root)
    {
        if(root==null) return;

        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
    }

    TreeNode build(int l,int r)
    {

        if(l>r) return null;

        int mid=(l+r)/2;

       TreeNode newNode = new TreeNode(res.get(mid));
       newNode.left= build(l,mid-1);
       newNode.right=build(mid+1,r);
       return newNode;
    }
}