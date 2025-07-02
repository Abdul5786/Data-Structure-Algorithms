class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
      HashMap<Integer,Integer> res=   new HashMap<>();

      for(int i=0;i<nums.length;i++)
      {

        int compliment =target-nums[i];

        if(res.containsKey(compliment))
        {
            return new int[]{res.get(compliment),i};
        }

        res.put(nums[i],i);
      }

    return new int[]{-1,-1};
    }
}