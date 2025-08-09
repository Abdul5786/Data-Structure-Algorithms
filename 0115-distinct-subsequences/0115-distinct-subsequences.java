class Solution {
    public int numDistinct(String s, String t) {

        int dp[][] = new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)
        {
            Arrays.fill(dp[i],-1);
        }

        return helper(s,t,0,0,dp);
        
    }

    public int helper(String s1,String s2, int i,int j,int dp[][])
    {

        if(j==s2.length()) return 1;
        if(i==s1.length()) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int ans =0;

        if(s1.charAt(i)==s2.charAt(j))
        {
             ans += helper(s1,s2,i+1,j+1,dp); // take
            ans += helper(s1, s2, i+1, j, dp);   // not take

        }

        else 
        {
            ans += helper(s1,s2,i+1,j,dp);
        }

        return dp[i][j]=ans;
    }
}