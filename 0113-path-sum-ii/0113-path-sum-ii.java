
class Solution {

    List<List<Integer>>  res= new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
       
        find(root,targetSum,new ArrayList<>());
        return res;
    }

    private void find(TreeNode root,int targetSum,List<Integer> ans)
    {


        if(root == null) return;

        ans.add(root.val);
         
        if(root.left==null && root.right==null )
        {
            if(targetSum==root.val)
            {
             res.add(new ArrayList<>(ans));
            }
        }
        find(root.left,targetSum-root.val,ans);
        find(root.right,targetSum-root.val,ans);
        ans.remove(ans.size()-1);
    }
   
}