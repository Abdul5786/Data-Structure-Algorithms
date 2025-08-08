class Solution {
    public int findMaxForm(String[] strs, int m, int n) 
    {
       int dp[][][] =  new int[m+1][n+1][strs.length];
       return helper(strs,m,n,0,dp); 
    }

    public int helper(String strs[],int m, int n, int index, int dp[][][])
    {

        if(index==strs.length || m+n==0 ) return 0;
        if(dp[m][n][index]!=0) return dp[m][n][index];
        
        int zero = countZeros(strs[index]);
        int ones = strs[index].length()-zero;
        
        int take =0 , skip =0;
        if(m>=zero && n>=ones)
        {

             take = helper(strs,m-zero,n-ones,index+1,dp)+1;
        }

         skip = helper(strs,m,n,index+1,dp);

         return dp[m][n][index] = Math.max(take,skip);

    }

    public int countZeros(String s)
    {
        int z=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='0')
            {
                z++;
            }
        }

        return z;
    }
}