class Solution {
    public int minDistance(String word1, String word2) 
    {
        int m = word1.length();
        int n = word2.length();

        int dp[][] = new int[m+1][n+1];

        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }

        int lcs = helper(word1,word2,0,0,dp);
        return  (m-lcs)+(n-lcs);
    }

    public int helper(String str1, String str2, int i, int j, int dp[][])
    {
        if(i>=str1.length() || j>=str2.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(str1.charAt(i) == str2.charAt(j))
        {
            dp[i][j] = 1+ helper(str1,str2,i+1,j+1,dp);
        }

        else 
        {
            dp[i][j] = Math.max(helper(str1,str2,i+1,j,dp),helper(str1,str2,i,j+1,dp));
        }

        return dp[i][j];
    }
}