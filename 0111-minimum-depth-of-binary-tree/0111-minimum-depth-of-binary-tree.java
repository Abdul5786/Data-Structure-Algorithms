class Solution {
    public int minDepth(TreeNode root) {
        // Agar root null hai toh 0 return kar (tree khali hai bro)
        if (root == null) {
            return 0;
        }
        // Agar leaf node mil gayi, toh depth 1 hai
        if (root.left == null && root.right == null) {
            return 1;
        }
        // Agar left null hai, toh right ka depth le +1 kar
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        // Agar right null hai, toh left ka depth le +1 kar
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        // Dono sides ka minimum depth le aur +1 kar (root ko include karte hue)
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}