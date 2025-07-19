class Solution {
    public int uniquePaths(int m, int n) 
    {
      int dp[][] =   new int[m+1][n+1];
      for(int i=0;i<=m;i++)
      {
        for(int j=0;j<=n;j++)
        {
            dp[i][j]= -1;
        }
      }

      return paths(m,n,dp);  
    }

    public int paths(int m, int n,int dp[][]) 
    {
        // unique path point
       if(m==1 && n==1) return 1; // 1 path mil gyaa

       if(m==0 || n==0) return 0; // invalid path 

       if(dp[m][n]!=-1) return dp[m][n];
       return dp[m][n] = paths(m,n-1,dp)+paths(m-1,n,dp);
           
    }
}