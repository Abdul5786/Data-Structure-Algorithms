class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res; 
    }

    static void preOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);             // Visit root
        preOrder(node.left, res);      // Left subtree
        preOrder(node.right, res);     // Right subtree
    }
}