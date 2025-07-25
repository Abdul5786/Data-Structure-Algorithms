class Solution {
    public int longestPalindromeSubseq(String s) 
    {
       int n =s.length();
       int dp[][] = new int[n][n];
       for (int i = 0; i < n; i++) {
           Arrays.fill(dp[i], -1);
       }
       return helper(s,0,n-1,dp);
    }

    public int helper(String s, int left,int right,int dp[][])
    {

      if(left>right) return 0;

      if(left==right) return 1; // single character always a palindrome

      if(dp[left][right] !=-1) return dp[left][right];

       if(s.charAt(left)==s.charAt(right))
       {
         dp[left][right] = 2 + helper(s,left+1,right-1,dp);
       }

       else {

         dp[left][right] = Math.max(helper(s,left+1,right,dp),helper(s,left,right-1,dp));
       }
      
      return dp[left][right];
    }
}