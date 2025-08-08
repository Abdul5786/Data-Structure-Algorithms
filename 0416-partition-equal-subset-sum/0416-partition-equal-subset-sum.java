class Solution {
    public boolean canPartition(int[] nums) 
    {
        int totalSum=0;
       for(int num:nums)
       {
         totalSum +=num; 
       }
       if(totalSum%2!=0) return false;
       
       int target = totalSum/2;
       Boolean dp[][] = new Boolean[nums.length][target+1];
       return helper(nums,0,target,dp);
    }

    public boolean helper(int nums[],int index,int sum ,Boolean dp[][])
    {
        if(sum==0) return true;
        if(index==nums.length || sum<0) return false;

        if(dp[index][sum]!=null) return dp[index][sum];
        
        boolean take = helper(nums,index+1,sum-nums[index],dp);
        boolean skip= helper(nums,index+1,sum,dp);
        return dp[index][sum]= take || skip;    
        
    }
}