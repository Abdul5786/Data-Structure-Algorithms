class Solution {
    public boolean canThreePartsEqualSum(int[] nums) 
    {
        int sum=0;
        for(int n: nums)
        {
            sum+=n;  // toatal sum of array 
        }

        if(sum%3!=0)
        {
           return false;
        }

        int target= sum/3;
        int currentSum=0;
        int count=0;


        for(int i=0;i<nums.length-1;i++)
        {

            currentSum+=nums[i];
            if(currentSum==target)
            {
                count++;
                currentSum=0;

                if(count==2)
                {
                    return true;
                }
            }

        }

        return false;
    }
}