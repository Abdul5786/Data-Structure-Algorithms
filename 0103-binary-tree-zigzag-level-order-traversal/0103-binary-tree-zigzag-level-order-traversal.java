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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
       List<List<Integer>> res =   new ArrayList<>();
       
       if(root==null) return res;


       Queue<TreeNode> q = new LinkedList<>();

       q.add(root);
       

       while(!q.isEmpty())
       {

         int size = q.size();

        List<Integer> ans =  new ArrayList<>();

        for(int i=0;i<size;i++)
        {

            TreeNode node =  q.poll();

            ans.add(node.val);

            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
            
        }

        res.add(ans);         
       }

       for(int i=1;i<res.size();i+=2)
       {
           List<Integer> list = res.get(i);
           Collections.reverse(list);
           res.set(i,list);
       }


       return res;
    }
}