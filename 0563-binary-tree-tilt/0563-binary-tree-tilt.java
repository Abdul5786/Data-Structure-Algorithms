class Solution {
    int totalTilt = 0;

    public int findTilt(TreeNode root) {
        sum(root);
        return totalTilt;
    }

    int sum(TreeNode node) {
        if (node == null) return 0;
        int left = sum(node.left);
        int right = sum(node.right);
        totalTilt += Math.abs(left - right);
        return node.val + left + right;
    }
}