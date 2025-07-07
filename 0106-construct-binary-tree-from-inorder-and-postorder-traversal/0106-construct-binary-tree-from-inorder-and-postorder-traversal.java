class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Helper se pura tree banayenge
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        // Base case: agar koi node nahi bachi
        if(inStart > inEnd || postStart > postEnd) return null;
        
        // Postorder ka last element root hota hai
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        // Root ka index find karo inorder mein
        int inRoot = inStart;
        while(inorder[inRoot] != rootVal) inRoot++;
        
        // Left subtree mein kitne nodes hain
        int numsLeft = inRoot - inStart;
        
        // Left subtree bana lo
        root.left = helper(inorder, inStart, inRoot-1, postorder, postStart, postStart+numsLeft-1);
        // Right subtree bana lo
        root.right = helper(inorder, inRoot+1, inEnd, postorder, postStart+numsLeft, postEnd-1);
        
        // Root return karo
        return root;
    }
}