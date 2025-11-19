class Solution {
    public int findFinalValue(int[] nums, int original) 
    {
        int requiredNumber =original;
        int i=0;

         while(i<nums.length)
        {
            if(nums[i]==requiredNumber)
            {
                requiredNumber  *=2;
                i=0;
            }
           
           else
           {
              i++;
           }
        }

        if(requiredNumber!=original)
        {
            return requiredNumber;
        }

        else
        {
            return original;
        }
    }
}