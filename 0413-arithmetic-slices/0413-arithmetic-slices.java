class Solution {

    int count=0 ,totalCount=0;
    public int numberOfArithmeticSlices(int[] nums) 
    {
        for(int i=2;i<nums.length;i++)
        {

            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])
            {
                count++;
                totalCount+=count;
            }

            else
            {
                count=0;
            }
        }
        
        return totalCount;
    }
}