
class Solution {
    public int maxLevelSum(TreeNode root) 
    {
      
       Queue<TreeNode> q =   new LinkedList<>();
       q.add(root);  

       int level=1, maxLevel=1, maxSum=root.val;

       while(!q.isEmpty())
       {

          int size= q.size(), sum=0;

          for(int i=0;i<size;i++)
          {
            
            TreeNode node = q.poll();

            sum+=node.val;

            if(node.left!=null) q.add(node.left);
            if(node.right!=null)q.add(node.right);
          }

          if(sum>maxSum)
          {
            maxSum=sum;
            maxLevel=level;
          }

          level++;
       }

       return maxLevel;
    }
}