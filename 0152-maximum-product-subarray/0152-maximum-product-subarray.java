class Solution {
    public int maxProduct(int[] nums) 
    {
        int ans =Integer.MIN_VALUE;

        int prefix=1 , suffix=1;

        for(int i=0;i<nums.length;i++)
        {
            
        if(prefix==0) prefix=1;
        if(suffix==0) suffix=1;

            prefix *= nums[i];
            suffix *=nums[nums.length-1-i];
          
          ans = Math.max(ans,Math.max(prefix,suffix));

        } 
       

        return ans; 
    }
}