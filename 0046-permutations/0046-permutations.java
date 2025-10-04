class Solution {

    List<List<Integer>> ans  = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) 
    {
        helper(nums,new ArrayList<>());
        return ans;
    }


    public void helper(int nums[],List<Integer> used)
    {

        // base case 

        if(used.size()==nums.length)
        {
            ans.add(new ArrayList<>(used));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            if(!used.contains(nums[i]))
            {
                used.add(nums[i]);
                helper(nums,used);
                // back track
                used.remove(used.size()-1);
            }
        }
    }
}