
class Solution {
    public boolean isBalanced(TreeNode root) 
    {
        int hieght =getHeight(root);
        if(hieght ==-1) return false;
        return true;
    }

    public int getHeight(TreeNode root)
    {
         if (root == null) return 0; // ✅ Base case
        int leftHeight =getHeight(root.left);
        int rightHeight= getHeight(root.right);
        if(leftHeight ==-1 || rightHeight==-1) return -1;

        if(Math.abs(leftHeight-rightHeight)>1) return -1;

        return 1+Math.max(leftHeight,rightHeight);
          

    }
}