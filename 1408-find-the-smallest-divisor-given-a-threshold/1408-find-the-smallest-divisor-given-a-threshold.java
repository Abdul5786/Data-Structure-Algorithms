class Solution {
    public int smallestDivisor(int[] nums, int threshold) 
    {
        int low=1;
        int high= getMax(nums);
        int ans=0;
        
        
        

        while(low<=high)
        {
            int mid = low+(high-low)/2;
            
            if(isPossible(nums,mid,threshold))
            {
               ans = mid;

               // try for minimum 

               high= mid-1;
            }

            else 
            {
                 low = mid+1;
            }

           
        }
         return ans;
    }

    public int getMax(int nums[])
    {
        int max=0;
        for(int num:nums)
        {
           max = Math.max(max,num);  
        }

        return max;
    }
    

    public boolean isPossible(int nums[],int divisor, int threshold)
    {

        int totalSum =0;

        for(int num:nums)
        {
            totalSum += Math.ceil((double)num/divisor);
        }
        
        return totalSum<=threshold;
    }
    
}