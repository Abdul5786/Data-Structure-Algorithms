class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) 
    {
        return find(root,low,high);
    }
    public int find(TreeNode root, int low, int high){
        
        
        int sum = 0;

        if(root==null)
        {
            return sum;
        }

        if(root.val>=low && root.val<=high)
        {
            sum +=root.val;
        }
        int left_sum = find(root.left,low,high);
        int right_sum = find(root.right,low,high);

        sum +=left_sum + right_sum;
        return sum;
    }
}