class Solution {
    public int pathSum(TreeNode root, int targetSum) 
    {
        if (root == null) return 0;
        return countFromNode(root, targetSum) 
            + pathSum(root.left, targetSum) 
            + pathSum(root.right, targetSum);
    }
    private int countFromNode(TreeNode node, long sum) {
        if (node == null) return 0;
        int count = 0;
        if (node.val == sum) count++;
        count += countFromNode(node.left, sum - node.val);
        count += countFromNode(node.right, sum - node.val);
        return count;
    }
}