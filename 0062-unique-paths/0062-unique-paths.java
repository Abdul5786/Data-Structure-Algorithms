class Solution {
    public int uniquePaths(int m, int n) 
    {
       int dp[][] = new int[m][n];

       for(int i=0;i<m;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(i==0 || j==0) dp[i][j]=1;
            else dp[i][j] = dp[i-1][j]+dp[i][j-1];
        }
       }

       return dp[m-1][n-1]; 
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