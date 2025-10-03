class Solution 
{
    public int findKthPositive(int[] nums, int k) 
    {
       int index=0;
       int currentValue=1;
       int countMissingNumber=0;

       while(countMissingNumber<k)
       {
                
         if(index<nums.length && nums[index]==currentValue)
         {
             index++;
         }

         else
         {
          
            countMissingNumber++;
            if(countMissingNumber==k)
            {
                return currentValue;
            }

         }

         currentValue++;

       }

       return -1; 
    }
}