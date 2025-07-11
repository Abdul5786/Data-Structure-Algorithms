
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);

    }

      private TreeNode   helper(int preorder[],int preStart,int preEnd,int inorder[], int inStart,int inEnd )
    {

        if(preStart>preEnd || inStart>inEnd) return null;

              // finding root node 

           int  rootVal =   preorder[preStart];

               // create tree 

         TreeNode root =  new TreeNode(rootVal);

         // finding root node in inorder


        int inRoot = inStart;
        while(inorder[inRoot] != rootVal) inRoot++;

         int leftSize = inRoot - inStart;


           root.left = helper(preorder,preStart+1,preStart+leftSize,inorder,inStart,inRoot-1);
           root.right =helper(preorder,preStart+leftSize+1,preEnd,inorder,inRoot+1,inEnd);

            return root;
    }

   
}