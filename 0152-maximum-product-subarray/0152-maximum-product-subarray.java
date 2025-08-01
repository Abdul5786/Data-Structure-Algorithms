class Solution {
    public int maxProduct(int[] nums) 
    {

       int ans=Integer.MIN_VALUE;

       int pref=1,suff=1;

       for(int i=0;i<nums.length;i++)
       {
        
        if(pref==0) pref=1;
        if(suff==0) suff=1;
         
         pref *=nums[i];
         suff *=nums[nums.length-1-i]; // calculating from backward

         ans =Math.max(ans,Math.max(pref,suff));

      

       } 

       return ans;
}
}