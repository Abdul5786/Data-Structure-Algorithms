class Solution {
    public int numRescueBoats(int[] nums, int limit) 
    {
        int left=0;
        int right=nums.length-1;
        int boatsRequired=0;

        Arrays.sort(nums);

        while(left<=right)
        {
             
        

            if(nums[left]+nums[right]<=limit) // found pair whose weight under the limit
            {
                boatsRequired++;
                left++;
                right--;
            }

            else
            {
                  right--;
                  boatsRequired++;
            }
        }

        return boatsRequired;

    }
}