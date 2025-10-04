class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) 
    {
         helper(nums,0,new ArrayList<>());
         return res;  
    }


    public void helper(int nums[],int index, List<Integer> ans)
    {

        // base case 

        if(index==nums.length)
        {
            res.add(new ArrayList<>(ans));
            return;
        }


        // pick

        ans.add(nums[index]);
        helper(nums,index+1,ans);

        // backtrack remove 

        ans.remove(ans.size()-1);

        helper(nums,index+1,ans);
    }
}