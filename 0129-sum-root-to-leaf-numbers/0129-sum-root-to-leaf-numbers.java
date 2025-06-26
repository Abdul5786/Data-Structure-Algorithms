
class Solution {

    int total=0;
    public int sumNumbers(TreeNode root) 
    {
        findSum(root,0);
        return total; 
    }

      void findSum(TreeNode root,int sum)
    {

        if(root==null) return;

        sum=sum*10+root.val;

        if(root.left==null && root.right==null)
        {
            total+=sum;
            return;
        }

        findSum(root.left,sum);
        findSum(root.right,sum);


    }
}