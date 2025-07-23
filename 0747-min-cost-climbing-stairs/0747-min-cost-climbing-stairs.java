class Solution {
    public int minCostClimbingStairs(int[] cost) 
    {
        int dp[] = new int[cost.length];
        int n= cost.length;

         dp[0] = cost[0];
         dp[1] =cost[1];

        for(int i=2;i<n;i++)
        {
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }

        return Math.min(dp[n-1],dp[n-2]);
    }
}

// class Solution {
//     public int minCostClimbingStairs(int[] cost) 
    
//        int dp[]= new int[n+1];
//        Arrays.fill(dp,-1);
//        return helper(n,cost,dp);

//     }

//     int helper(int n, int cost[],int dp[])
//     {
//         if(n==0 || n==1)
//         {
//             dp[n]=0;
//             return 0;
//         }

//         if(dp[n]!=-1)
//         {
//             return dp[n];
//         }
//         int oneStep = cost[n-1]+helper(n-1,cost,dp);
//         int twoStep = cost[n-2]+helper(n-2,cost,dp);

//         dp[n] =  Math.min(oneStep,twoStep); 
//         return dp[n];
//     }
// }