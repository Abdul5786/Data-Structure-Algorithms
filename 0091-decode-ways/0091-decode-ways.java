class Solution {
    public int numDecodings(String s) 
    {
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }

    public int helper(String s, int index, int dp[])
    {
        if(index==s.length()) return 1; // got one valid way

        if(s.charAt(index) =='0') return 0; // not valid

        if(dp[index]!=-1) return dp[index];

        int ways = helper(s,index+1,dp);

        if(index+1<s.length() && Integer.parseInt(s.substring(index,index+2))<=26)
            ways+= helper(s,index+2,dp);

            return ways;
    }
}