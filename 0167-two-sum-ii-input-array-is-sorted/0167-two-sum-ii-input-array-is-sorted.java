class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int start=0 ;

        int end = nums.length-1;

        int sum= 0;

        while(start<end)
        {
         
           sum = nums[start]+nums[end];

            if(sum==target)
            {
                return new int[]{start+1,end+1};
            }

            else if(sum>target)
            {
                 end--;
            }

            else
            {
                 start++;
            }

        }

        return new int[]{-1,-1};
    }
}